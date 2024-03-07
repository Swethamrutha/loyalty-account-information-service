/* @CopyRights  Tesco. All rights are reserved. */
package com.tesco.offers.account.balances.dao.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author:Tesco
 * @Date:Jan 7, 2019
 * @Time:7:46:50 PM 
 * @Description:Tesco Developing Project
 */

public class BalanceDAOResponse {

	private long availablePts;
	private double creditLimit;
	private double balanceAmt;
	private String respCode;
	private String respMsg;
	
	
	
	
	 
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public long getAvailablePts() {
		return availablePts;
	}
	public void setAvailablePts(long availablePts) {
		this.availablePts = availablePts;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getBalanceAmt() {
		return balanceAmt;
	}
	public void setBalanceAmt(double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BalanceDAOResponse [availablePts=");
		builder.append(availablePts);
		builder.append(", creditLimit=");
		builder.append(creditLimit);
		builder.append(", balanceAmt=");
		builder.append(balanceAmt);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
