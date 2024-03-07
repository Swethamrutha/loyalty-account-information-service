package com.tesco.offers.account.features.dao.beans;

public class FeaturesDaoRequest {

	private String clientid;
	private String channelid;
	private String accountnumber;
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeaturesDaoRequest [clientid=");
		builder.append(clientid);
		builder.append(", channelid=");
		builder.append(channelid);
		builder.append(", accountnumber=");
		builder.append(accountnumber);
		builder.append("]");
		return builder.toString();
	}
	
	

}
