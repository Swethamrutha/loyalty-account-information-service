package com.tesco.offers.account.process.beans;

import java.util.Date;

public class FeatureProcess {
	
	private boolean isEligibility;
	private Date expiryDate;
	private String  desc;
	private String code;
	
	public boolean getIsEligibility() {
		return isEligibility;
	}
	public void setIsEligibility(boolean isEligibility) {
		this.isEligibility = isEligibility;
	}
	
	
	
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setEligibility(boolean isEligibility) {
		this.isEligibility = isEligibility;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeatureProcess [isEligibility=");
		builder.append(isEligibility);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}
	
	
		
	
		
	
}