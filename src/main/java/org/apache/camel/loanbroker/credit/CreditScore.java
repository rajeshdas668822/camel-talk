package org.apache.camel.loanbroker.credit;

import java.io.Serializable;

public class CreditScore  implements Serializable{
	
	
	private long creditScore;
	private String SSN;
	
	
	
	public CreditScore(long creditScore, String SSN) {
		super();
		this.creditScore = creditScore;
		this.SSN = SSN;
	}
	public long getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(long creditScore) {
		this.creditScore = creditScore;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SSN == null) ? 0 : SSN.hashCode());
		result = prime * result + (int) (creditScore ^ (creditScore >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditScore other = (CreditScore) obj;
		if (SSN == null) {
			if (other.SSN != null)
				return false;
		} else if (!SSN.equals(other.SSN))
			return false;
		if (creditScore != other.creditScore)
			return false;
		return true;
	}
	

}
