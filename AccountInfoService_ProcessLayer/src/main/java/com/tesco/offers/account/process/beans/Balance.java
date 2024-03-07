package com.tesco.offers.account.process.beans;

public class Balance {
	
	private double cardBalance;
	private double creditLimit;
	private long availablepts;
	public double getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public long getAvailablepts() {
		return availablepts;
	}
	public void setAvailablepts(long availablepts) {
		this.availablepts = availablepts;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Balance [cardBalance=");
		builder.append(cardBalance);
		builder.append(", creditLimit=");
		builder.append(creditLimit);
		builder.append(", availablepts=");
		builder.append(availablepts);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
