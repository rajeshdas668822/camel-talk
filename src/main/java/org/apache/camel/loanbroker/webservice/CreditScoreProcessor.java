package org.apache.camel.loanbroker.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.loanbroker.credit.CreditAgencyWS;
import org.apache.camel.loanbroker.credit.CreditHistoryDetails;
import org.apache.camel.loanbroker.credit.Customer;
import org.apache.camel.loanbroker.service.RFQProviderImpl;
import org.apache.camel.loanbroker.util.LoanBrokerKeiHelper;
import org.apache.cxf.BusFactory;
import org.apache.cxf.frontend.ClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.kie.api.runtime.KieSession;

/**
 * Credit score processor.
 */

public class CreditScoreProcessor implements Processor {
    private String creditAgencyAddress;
    private CreditAgencyWS proxy;

    public CreditScoreProcessor(String address) {
        creditAgencyAddress = address;
        proxy = getProxy();
        
    }

    private CreditAgencyWS getProxy() {
        // Here we use JaxWs front end to create the proxy
        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
        ClientFactoryBean clientBean = proxyFactory.getClientFactoryBean();
        clientBean.setAddress(creditAgencyAddress);
        clientBean.setServiceClass(CreditAgencyWS.class);
        clientBean.setBus(BusFactory.getDefaultBus());
        return (CreditAgencyWS)proxyFactory.create();
    }

    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        List<Object> request = exchange.getIn().getBody(List.class);
        List<String> recipientList =new ArrayList<String>();
        /*recipientList.add("bank1WS");
        recipientList.add("bank2WS");
        recipientList.add("bank3WS");*/
        
        

        String ssn = (String) request.get(0);
        Double amount = (Double) request.get(1);
        Integer incomeAmount = (Integer) request.get(2);
        Integer loanDuration = (Integer) request.get(3);
        //int historyLength = proxy.getCreditHistoryLength(ssn);
       // int score = proxy.getCreditScore(ssn);
        
        CreditHistoryDetails creditDetails=proxy.getCreditHistory(ssn, amount);
        creditDetails.setTenure(""+loanDuration);

        // create the invocation message for Bank client
        List<Object> bankRequest = new ArrayList<Object>();
        bankRequest.add(ssn);
        bankRequest.add(amount);
        bankRequest.add(loanDuration);
        bankRequest.add(creditDetails);        
        exchange.getOut().setBody(bankRequest);
        exchange.getOut().setHeader("creditScore",creditDetails.getCreditScore());
       
        
        
        //Integrating with Rule Engine
        
        LoanBrokerKeiHelper loanBrokerKieHelper= new LoanBrokerKeiHelper();
        KieSession kieSession = loanBrokerKieHelper.getKieSession();
        kieSession.setGlobal("bankList", recipientList);
        kieSession.setGlobal("rfqProvider", new RFQProviderImpl());
        Customer customer = new Customer(ssn, incomeAmount, loanDuration);
        System.out.println("customer ::: " +customer);
        
        loanBrokerKieHelper.insertFactToSession(kieSession, customer);
        System.out.println("recipientList ::: " +recipientList);
        exchange.getOut().setHeader("recipientList", recipientList);
        exchange.getOut().setHeader("operationName", "getQuoteForAll");
        System.out.println("Proccessing Pass  from CreditScoreProcessor ");
        
    }

}
