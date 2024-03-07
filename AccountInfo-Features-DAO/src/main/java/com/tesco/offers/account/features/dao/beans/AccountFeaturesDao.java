package com.tesco.offers.account.features.dao.beans;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
public class AccountFeaturesDao {
	private boolean isEligibility;
	private String code;
	private String desc;
	
	private Date expiryDate;
	
	
	
	
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public boolean getIsEligibility() {
		return isEligibility;
	}
	public void setEligibility(boolean isEligibility) {
		this.isEligibility = isEligibility;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountFeaturesDao [isEligibility=");
		builder.append(isEligibility);
		builder.append(", code=");
		builder.append(code);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append("]");
		return builder.toString();
	}
	
	

}
