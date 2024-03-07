package com.tesco.offers.account.process.beans;

import java.util.List;



public class AccountInfoProcessResponseBean {
	
	private String respCode;
	private String userMsg;
	
	private Balance balance;
	private List<FeatureProcess> feature;
	private List<String> linkedCardrelation;
	
	
	
	
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getUserMsg() {
		return userMsg;
	}
	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}
	public Balance getBalance() {
		return balance;
	}
	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	public List<FeatureProcess> getFeature() {
		return feature;
	}
	public void setFeature(List<FeatureProcess> feature) {
		this.feature = feature;
	}
	public List<String> getLinkedCardrelation() {
		return linkedCardrelation;
	}
	public void setLinkedCardrelation(List<String> linkedCardrelation) {
		this.linkedCardrelation = linkedCardrelation;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountInfoProcessResponseBean [respCode=");
		builder.append(respCode);
		builder.append(", userMsg=");
		builder.append(userMsg);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", feature=");
		builder.append(feature);
		builder.append(", linkedCardrelation=");
		builder.append(linkedCardrelation);
		builder.append("]");
		return builder.toString();
	}
	
	
	
		
	
	
}