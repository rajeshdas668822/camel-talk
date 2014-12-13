package org.apache.camel.loanbroker.webservice;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IntrestRatecalculator {
	
	/*static Map<String,Map<Integer,Double>> bankTenureMapping=new ConcurrentHashMap<String, Map<Integer,Double>>();
	
	static {
		 
		Map<Integer,Double> yearToRateMap=new ConcurrentHashMap<Integer, Double>();
		yearToRateMap.put(1, 5.8);
		yearToRateMap.put(2, 6.1);
		yearToRateMap.put(3, 6.4);
		yearToRateMap.put(4, 6.9);
		yearToRateMap.put(5, 7.9);
		
		bankTenureMapping.put(key, value)
		    
		 
	}*/
	
	
	
	public enum NumberOfPaymentByTenure {
	    ONE(12), TWO(24), THREE(36),FOURE(48),FIVE(60);
	    private final int value;

	    private NumberOfPaymentByTenure(int value) {
	        this.value = value;
	    }

		public int getValue() {
			return value;
		}
	    
	    
	}
	
	

	

	public static BigDecimal getIntrestRate(double loanAmount, int tenure, double intrestRate ){	
		
		System.out.println(" The values  from Web service::loanAmount=>"+loanAmount+":-tenure->"+tenure+":-intrestRate->"+intrestRate);
		
		MathContext mc=new MathContext(5);
		//Calculate the monthly interest rate by dividing the annual interest rate by 12		
		BigDecimal monthlyIntrestRate=new BigDecimal(intrestRate).divide(new BigDecimal(12),mc).divide(new BigDecimal(100));	
		
		System.out.println("monthlyIntrestRate:="+monthlyIntrestRate);
		
		//Add 1 to the monthly interest rate just calculated
		BigDecimal interRate=monthlyIntrestRate.add(BigDecimal.ONE);
		
		System.out.println("interRate:="+interRate);
		//		
		BigDecimal tempRate=interRate.pow(tenure,mc);
		
		System.out.println("After Power :="+tempRate);
		
		BigDecimal tempRate2=tempRate.subtract(BigDecimal.ONE);
		
		BigDecimal calculatedloanAmount=monthlyIntrestRate.multiply(new BigDecimal(loanAmount));
		
		BigDecimal emi=calculatedloanAmount.multiply(tempRate.divide(tempRate2,mc));
				
		return emi;
	}
	
	
	public static void main(String args [] ){		
		IntrestRatecalculator rateCal=new IntrestRatecalculator();
		
	
		System.out.println(rateCal.getIntrestRate(100000, 180, 11));
		System.out.println(rateCal.getIntrestRate(30000, 36,15));
		System.out.println(rateCal.getIntrestRate(30000, 36,6.8));
		System.out.println(rateCal.getIntrestRate(30000, 36,5.88));
		
	}
	
	

}
