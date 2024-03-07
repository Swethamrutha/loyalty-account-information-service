package com.tesco.offers.account.process.beans;

public class BalanceProcess {
	
	private double cardbalance;
	private double creditlimit;
	private long availablepts;
	public double getCardbalance() {
		return cardbalance;
	}
	public void setCardbalance(double cardbalance) {
		this.cardbalance = cardbalance;
	}
	public double getCreditlimit() {
		return creditlimit;
	}
	public void setCreditlimit(double creditlimit) {
		this.creditlimit = creditlimit;
	}
	public long getAvailablepts() {
		return availablepts;
	}
	public void setAvailablepts(long availablepts) {
		this.availablepts = availablepts;
	}
	@Override
	public String toString() {
		return "BalanceProcess [cardbalance=" + cardbalance + ", creditlimit=" + creditlimit + ", availablepts="
				+ availablepts + "]";
	}
	

	
	

}
