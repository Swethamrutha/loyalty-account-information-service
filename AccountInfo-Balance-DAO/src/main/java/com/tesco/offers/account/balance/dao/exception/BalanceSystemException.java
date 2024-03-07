/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.dao.exception;

/**
 * @author:Tesco
 * @Date:Jan 25, 2019
 * @Time:9:04:11 PM
 * @Description:Tesco Project
 */
public class BalanceSystemException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String respCode;
	private String respMsg;
	
	
	public BalanceSystemException(String respCode, String respMsg) {
		
		this.respCode = respCode;
		this.respMsg = respMsg;
	}
	
	
	public String getRespCode() {
		return respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}


	@Override
	public String toString() {
		return "BalanceSystemException [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}
}
