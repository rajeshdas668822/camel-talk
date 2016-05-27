package org.apache.camel.loanbroker.service;

import java.util.List;

public interface RFQProvider {
	
	public List<String> getListOfBanksBasedOnCreditScore(Long creditScore);

}
