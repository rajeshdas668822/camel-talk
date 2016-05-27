package org.apache.camel.loanbroker.webservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.camel.Exchange;

import org.apache.camel.Processor;
import org.apache.camel.language.XPath;
import org.apache.camel.loanbroker.bank.BankQuote;

public class ResletToSoapMapper {
	
	 private static String url="http://localhost:9008/loanBroker";


	public List<BankQuote> process(@XPath("/newRoot/name/text()")String fin,@XPath("/newRoot/amount/text()")String amount,
                        @XPath("/newRoot/tenure/text()")String tenure, @XPath("/newRoot/incomeAmount/text()")String incomeAmount ) throws Exception {
		
		 LoanBrokerWS loanBroker = Client.getProxy(url);   
	        List<BankQuote> bankQuSet=new ArrayList<BankQuote>();
	        bankQuSet.addAll(loanBroker.getLoanQuoteForAll(fin, Double.valueOf(amount),Integer.valueOf(incomeAmount), Integer.valueOf(tenure)));
	        Collections.sort(bankQuSet, new BankQuoteComparator());
	   
	        System.out.println("Result: {}"+bankQuSet);
	        
	       return bankQuSet;
		

	}
	
	
	 public  class BankQuoteComparator implements Comparator<BankQuote>{
			@Override
			public int compare(BankQuote o1, BankQuote o2) {
				if(o1.getRate() < o2.getRate() ){
					return -1;
					
				}else if(o1.getRate() > o2.getRate())
					return 1;
				else 
					return 0;
				
			}
	    	
	    }

}
