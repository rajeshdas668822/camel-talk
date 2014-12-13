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

import java.io.Serializable;

public class BankQuote implements Serializable{
    private String bankName;
    private String ssn;
    private Double rate;
    private Double loanAmount; 
    private Double leftOverAmount;
    private String tenure;
    private Double emi;

    public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLeftOverAmount() {
		return leftOverAmount;
	}

	public void setLeftOverAmount(Double leftOverAmount) {
		this.leftOverAmount = leftOverAmount;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

	public BankQuote() {
    }

    public BankQuote(String name, String ssn, Double rate, Double loanAmount,Double leftOverAmount,String tenure,Double emi) {
        bankName = name;
        this.ssn = ssn;
        this.rate = rate;
        this.emi=emi;
        this.leftOverAmount=leftOverAmount;
        this.loanAmount=loanAmount;
        this.tenure=tenure;
        
    }
    
    
    public BankQuote(String name, String s, Double r) {
        bankName = name;
        ssn = s;
        rate = r;
        
       
    }

    public void setBankName(String name) {
        bankName = name;
    }

    public void setSsn(String s) {
        ssn = s;
    }

    public void setRate(Double r) {
        rate = r;
    }

    public String getBankName() {
        return bankName;
    }

    public String getSsn() {
        return ssn;
    }

    public Double getRate() {
        return rate;
    }

    public String toString() {
        return "[ssn:" + ssn + " bank:" + bankName + " rate:" + rate + "]";
    }



	

	

}
