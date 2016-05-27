package org.apache.camel.loanbroker.credit;

import java.io.Serializable;

public class Customer implements Serializable {
	
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", amount=" + amount + ", loanDuration=" + loanDuration + "]";
	}
	private String ssn;
	private Integer amount; 
	private Integer loanDuration;
	
	
	public Customer(String ssn, Integer amount, Integer loanDuration) {
		super();
		this.ssn = ssn;
		this.amount = amount;
		this.loanDuration = loanDuration;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((loanDuration == null) ? 0 : loanDuration.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		Customer other = (Customer) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (loanDuration == null) {
			if (other.loanDuration != null)
				return false;
		} else if (!loanDuration.equals(other.loanDuration))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}
	
	
	

}
