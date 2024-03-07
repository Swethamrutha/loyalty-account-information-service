/* @CopyRights  Tesco. All rights are reserved. */
package com.tesco.offers.account.balances.dao.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author:Tesco
 * @Date:Jan 7, 2019
 * @Time:7:48:05 PM 
 * @Description:Tesco Developing Project
 */

public class BalanceDaoRequest {
	
	private String clientid;
	private String channelid;
	private String accountnumber;
	
	
	
	public BalanceDaoRequest() {
		super();
	}
	public BalanceDaoRequest(String clientid, String channelid, String accountnumber) {
		super();
		this.clientid = clientid;
		this.channelid = channelid;
		this.accountnumber = accountnumber;
	}
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
		builder.append("BalanceDaoRequest [clientid=");
		builder.append(clientid);
		builder.append(", channelid=");
		builder.append(channelid);
		builder.append(", accountnumber=");
		builder.append(accountnumber);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
