/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.loanbroker.bank;
import org.apache.camel.loanbroker.credit.CreditHistoryDetails;
import org.apache.camel.loanbroker.webservice.IntrestRatecalculator;
import org.apache.camel.loanbroker.webservice.IntrestRatecalculator.NumberOfPaymentByTenure;

//START SNIPPET: bankImpl
public class Bank implements BankWS {
    private String bankName;
    private double primeRate;

    public Bank(String name) {
        bankName = name;
        primeRate = getPrimeRate(name);
    }

    public String getBankName() {
        return bankName;
    }

    public BankQuote getQuote(String ssn, double loanAmount, int loanDuration, int creditHistory, int creditScore) {
        Double rate = primeRate + (double)(loanDuration / 12) / 10 + Math.random() * 10 / 10;
        // Wait for a while
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // do nothing here
        }
        BankQuote result = new BankQuote(bankName, ssn, rate);
        return result;
    }
    
    
    // This is the place Where You need to write the details
    public BankQuote getQuoteForAll(String ssn, double loanAmount, int loanDuration,  CreditHistoryDetails crediHistory) {
        //Double rate = primeRate + (double)(loanDuration / 12) / 10 + Math.random() * 10 / 10; 
    
        BankQuote result = new BankQuote(bankName, ssn, primeRate,loanAmount,crediHistory.getLeftOverAmountforBorrow(),""+loanDuration,
        		IntrestRatecalculator.getIntrestRate(loanAmount,getLoanTerm(loanDuration), primeRate).doubleValue());
        return result;
    }
    
    
    
    private double getPrimeRate(String bankName ){    
    	if(bankName.equals("POSB")){
    		return 5.88;
    	}else if(bankName.equals("ANZ")){
    		return 6.80;
    	}else if(bankName.equals("HSBC")){
    		return 7.20;
    	}else if(bankName.equals("Citi")){
    		return 7.5;
    	}else if(bankName.equals("OCBC")){
    		return 15;
    	}else{
    		return 8;
    	}	
    }
    
    
    private Integer getLoanTerm(Integer loanTerm){
    	if(loanTerm == 1){
    		return NumberOfPaymentByTenure.ONE.getValue();
    	}else 
    	if(loanTerm == 2){
    		return NumberOfPaymentByTenure.TWO.getValue();
    	}else if(loanTerm == 3){
    		return NumberOfPaymentByTenure.THREE.getValue();
    	}else if(loanTerm == 4){
    		return NumberOfPaymentByTenure.FOURE.getValue();
    	}else if(loanTerm == 5){
    		return NumberOfPaymentByTenure.FIVE.getValue();
    	}else {
    		return 0;
    	}
    	
    }

}
//END SNIPPET: bankImpl
