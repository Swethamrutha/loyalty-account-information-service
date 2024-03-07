package com.tesco.offers.account.process.beans;

import java.util.List;

public class AccountInfoProcessRequestBean {
	
	private String clientid;
	private String channelid;
	private String accountnumber;
	private String typeofaccount;
	
	
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
	public String getTypeofaccount() {
		return typeofaccount;
	}
	public void setTypeofaccount(String typeofaccount) {
		this.typeofaccount = typeofaccount;
	}
	@Override
	public String toString() {
		return "AccountInfoProcessRequestBean [clientid=" + clientid + ", channelid=" + channelid + ", accountnumber="
				+ accountnumber + ", typeofaccount=" + typeofaccount + "]";
	}

	
	
	
	

}
