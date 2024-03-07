package com.tesco.offers.account.process.beans;

import java.util.List;

public class LinkedCardProcess {

	private boolean isPrimary;
	private List<String> linkedCards;
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public List<String> getLinkedCards() {
		return linkedCards;
	}
	public void setLinkedCards(List<String> linkedCards) {
		this.linkedCards = linkedCards;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LinkedCardProcess [isPrimary=");
		builder.append(isPrimary);
		builder.append(", linkedCards=");
		builder.append(linkedCards);
		builder.append("]");
		return builder.toString();
	}
	
}
