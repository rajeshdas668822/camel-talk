package org.apache.camel.loanbroker.util;

public class CreditScoreUtil {
	
	public static boolean isCustomerPR(String ssn){
		if(ssn.startsWith("P"))
		   return true;
		else
		    return false;
	}
	
	
	public static boolean isCustomerCitizen(String ssn){
		if(ssn.startsWith("C"))
		   return true;
		else
		    return false;
	}
	
	public static boolean isCustomerOnEP(String ssn){
		if(ssn.startsWith("E"))
		   return true;
		else
		   return false;
	}

	
}
