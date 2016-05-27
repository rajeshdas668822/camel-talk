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
package org.apache.camel.loanbroker.credit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//START SNIPPET: creditAgencyImpl
public class CreditAgency implements CreditAgencyWS {
	
	private  Map<String,CreditHistoryDetails> creditHistoryMap=new ConcurrentHashMap<String,CreditHistoryDetails>();
	
	protected void init(){
		//creditHistoryMap
		CreditHistoryDetails cr=new CreditHistoryDetails();
		cr.setFin("P3132910");		
		cr.setCreditScore(7);
		creditHistoryMap.put(cr.getFin(), cr);
		
		cr=new CreditHistoryDetails();
		cr.setFin("C2233910");
		cr.setCreditScore(6);
		creditHistoryMap.put(cr.getFin(), cr);
		
		cr=new CreditHistoryDetails();
		cr.setFin("E1122334");
		cr.setCreditScore(8);
		creditHistoryMap.put(cr.getFin(), cr);
		
		cr=new CreditHistoryDetails();
		cr.setFin("E665544");
		cr.setCreditScore(5);
		creditHistoryMap.put(cr.getFin(), cr);
		
	}
	
	 public int getCreditHistoryLength(String ssn){
	      int creditScore = (int)(Math.random() * 600 + 300);
	        return creditScore;
	 }

    public CreditHistoryDetails getCreditHistory(String ssn, double amountTobeBorrowed) {
       
    	init();
    	CreditHistoryDetails creditDetails =creditHistoryMap.get(ssn);
    	creditDetails.setLeftOverAmountforBorrow(amountTobeBorrowed - creditDetails.getAmountBorrowed());  
    	return creditDetails;
    }

    public int getCreditScore(String ssn) {
        int creditHistoryLength = (int)(Math.random() * 19 + 1);
        return creditHistoryLength;
    }
    
    
    
    
    
    





}
//END SNIPPET: creditAgencyImpl
