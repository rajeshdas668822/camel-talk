package org.apache.camel.loanbroker.credit;

import java.io.Serializable;

public class CreditHistoryDetails implements Serializable {
	
	String fin;
    double amountBorrowed;
	double leftOverAmountforBorrow;
	double creditScore;
	String tenure;
	
	public CreditHistoryDetails(){}
	
	public CreditHistoryDetails(String fin, double amountBorrowed, double leftOverAmountforBorrow, double creditScore,
			String tenure) {
		super();
		this.fin = fin;
		this.amountBorrowed = amountBorrowed;
		this.leftOverAmountforBorrow = leftOverAmountforBorrow;
		this.creditScore = creditScore;
		this.tenure = tenure;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public double getCreditScore() {
		return creditScore;
	}
	
	public void setCreditScore(double creditScore) {
		this.creditScore = creditScore;
	}
	
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public double getAmountBorrowed() {
		return amountBorrowed;
	}
	public void setAmountBorrowed(double amountBorrowed) {
		this.amountBorrowed = amountBorrowed;
	}
	public double getLeftOverAmountforBorrow() {
		return leftOverAmountforBorrow;
	}
	public void setLeftOverAmountforBorrow(double leftOverAmountforBorrow) {
		this.leftOverAmountforBorrow = leftOverAmountforBorrow;
		//caclulateCreditScore(this.leftOverAmountforBorrow);
	}
	

}
