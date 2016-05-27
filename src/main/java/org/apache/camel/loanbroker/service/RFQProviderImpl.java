package org.apache.camel.loanbroker.service;

import java.util.ArrayList;
import java.util.List;

public class RFQProviderImpl implements RFQProvider {

	@Override
	public List<String> getListOfBanksBasedOnCreditScore(Long creditScore) {
		
		List<String> bankList =new ArrayList<String>();
		if( creditScore <= 5){
			bankList.add("bank1WS");
			bankList.add("bank2WS");			
		}else if(creditScore > 5 && creditScore < 7){
			bankList.add("bank1WS");
			bankList.add("bank2WS");
			bankList.add("bank3WS");
		}else if(creditScore > 7){
			bankList.add("bank1WS");
			bankList.add("bank2WS");
			bankList.add("bank3WS");
			bankList.add("bank4WS");
			bankList.add("bank5WS");
		}
		
		
		return bankList;
	}

}
