package com.tesco.offers.account.features.dao.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeaturesDaoResponse {
	
	private String statusCode;
	private String statusMsg;
	
	private List<AccountFeaturesDao> accountfeatures;
	
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
	public List<AccountFeaturesDao> getAccountfeatures() {
		return accountfeatures;
	}
	
	public void setAccountfeatures(List<AccountFeaturesDao> accountfeatures) {
		this.accountfeatures = accountfeatures;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeaturesDaoResponse [statusCode=");
		builder.append(statusCode);
		builder.append(", statusMsg=");
		builder.append(statusMsg);
		builder.append(", accountfeatures=");
		builder.append(accountfeatures);
		builder.append("]");
		return builder.toString();
	}
		

}
