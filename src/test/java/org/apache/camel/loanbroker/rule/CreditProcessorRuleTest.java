package org.apache.camel.loanbroker.rule;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.loanbroker.credit.Customer;
import org.apache.camel.loanbroker.service.RFQProviderImpl;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.Results;
import org.kie.api.command.Command;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CreditProcessorRuleTest {

static final Logger LOG = LoggerFactory.getLogger(CreditProcessorRuleTest.class);
	
	@Test
	public void test() {
		 System.out.println("### Running loadingRulesFromClassPath() Test ###");
	     /* KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.newKieClasspathContainer();

	        Results results = kContainer.verify();
	        results.getMessages().stream().forEach((message) -> {
	            System.out.println(">> Message ( "+message.getLevel()+" ): "+message.getText());
	        });
	        assertThat(false, is(results.hasMessages(Message.Level.ERROR)));
	        kContainer.getKieBaseNames().stream().map((kieBase) -> {
	            System.out.println(">> Loading KieBase: "+ kieBase );
	            return kieBase;
	        }).forEach((kieBase) -> {
	            kContainer.getKieSessionNamesInKieBase(kieBase).stream().forEach((kieSession) -> {
	                System.out.println("\t >> Containing KieSession: "+ kieSession );
	            });
	        });*/
	        
	        // Let's load the configurations for the kmodule.xml file 
	        //  defined in the /src/test/resources/META-INF/ directory
		 
		    KieBase kieBase= createKBase();
		   
	        KieSession kieSession = kieBase.newKieSession();

	        
	       // ssn=P3132910, amount=5000, loanDuration=5
	        //ssn=E1122334, amount=7000, loanDuration=5
	        Customer customer = new Customer("E1122334",7000,5);
	        //CreditScore creditScore= new CreditScore(6, "C700096");
	        List<String> bankList = new ArrayList<String>();
	        try{
	        kieSession.setGlobal("bankList", bankList);
	        kieSession.setGlobal("rfqProvider", new RFQProviderImpl());
	        
	        kieSession.insert(customer);
	       // kieSession.insert(creditScore);
	       // kieSession.insert(order);

	        int fired = kieSession.fireAllRules();
	        //assertThat(1, is(fired));
	        
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        }

	        //
	       // assertThat(5.0, is(order.getDiscount().getPercentage()));
	        
	        System.out.println(" Bank List ::: "+bankList);

	        System.out.println("### Finished loadingRulesFromLocalKieModule() Test ###");
	        /* customer.setCategory(Customer.Category.BRONZE);

	        Order order = new Order();
	        order.setCustomer(customer);*/

	       
        
	}
	
	
	   @Test
	    public void statelessSessionTest() {
	        System.out.println("### Running statelessSessionTest() Test ###");
	        KieServices ks = KieServices.Factory.get();
	        KieContainer kContainer = ks.newKieClasspathContainer();

	        Results results = kContainer.verify();
	        StatelessKieSession statelessKieSession = kContainer.newStatelessKieSession("creditSession");
	        
	        Assert.assertNotNull(statelessKieSession);
	        
	        Customer customer = new Customer("E1122334",7000,5);	        
	        List<String> bankList = new ArrayList<String>();
	      
	  
	        
	        Command newbankListGlobal = ks.getCommands().newSetGlobal("bankList", bankList);
	        Command newRfqprovider = ks.getCommands().newSetGlobal("rfqProvider", new RFQProviderImpl());
	        Command newInsertCustomer = ks.getCommands().newInsert(customer);
	        Command newFireAllRules = ks.getCommands().newFireAllRules("outRule");
	        List<Command> cmds = new ArrayList<Command>();
	        cmds.add(newbankListGlobal);
	        cmds.add(newRfqprovider);
	        cmds.add(newInsertCustomer);
	        cmds.add(newFireAllRules);
	        ExecutionResults execResults = statelessKieSession.execute(ks.getCommands().newBatchExecution(cmds));
	        
	       // List<String> bankList2 = (List<String>)execResults.getValue("bankList");
	        //int fired = (Integer)execResults.getValue("outFired");

	        //assertThat(1, is(fired));
	        //assertThat(10.0, is(order.getDiscount().getPercentage()));
	        System.out.println(bankList);

	        System.out.println("### Finished statelessSessionTest() Test ###");
	    }
	
	private KieBase createKBase(){
		
		KieHelper kieHelper = new KieHelper();		
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/credit/banklist-on-creditScore.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/credit/credit-score-evaluator-for-citizen.drl"), ResourceType.DRL);
		kieHelper.addResource(ResourceFactory.newClassPathResource("rules/credit/credit-score-evaluator-for-epholder.drl"), ResourceType.DRL);
		Results results = kieHelper.verify();
		/* results.getMessages().stream().forEach((message) -> {
	            System.out.println(">> Message ( "+message.getLevel()+" ): "+message.getText());
	        });
	        assertThat(false, is(results.hasMessages(Message.Level.ERROR)));*/
		   KieBase kieBase = kieHelper.build();
		
		
		
		return kieBase;
		
	}

}
