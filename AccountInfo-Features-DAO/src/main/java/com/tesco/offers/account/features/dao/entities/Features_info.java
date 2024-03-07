/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.features.dao.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author:Tesco
 * @Date:Feb 4, 2019
 * @Time:8:01:22 PM
 * @Description:Tesco Project
 */



@Entity
@Table(name="features_info")
public class Features_info implements Serializable {

 static final long serialVersionUID = 1L;
 
 @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private Integer id;
	
	@Column
	private String cardNumber;
	
	@Column(name="Code")
	private String code;
	
	@Column
	private String desc;
	
	@Column
	private boolean isEligible;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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

	
	public boolean isEligible() {
		return isEligible;
	}

	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


		
    
	
	
	

	
	
	
	
	
	
	
	
	
}
