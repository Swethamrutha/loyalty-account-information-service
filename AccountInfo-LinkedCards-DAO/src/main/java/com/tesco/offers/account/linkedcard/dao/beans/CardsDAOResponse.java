package com.tesco.offers.account.linkedcard.dao.beans;

import java.util.List;

public class CardsDAOResponse {
	
	private String statusCode;
	private String statusMsg;
    private List<String> linkedCards;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
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
		builder.append("CardsDAOResponse [statusCode=");
		builder.append(statusCode);
		builder.append(", statusMsg=");
		builder.append(statusMsg);
		builder.append(", linkedCards=");
		builder.append(linkedCards);
		builder.append("]");
		return builder.toString();
	}
    
    
}