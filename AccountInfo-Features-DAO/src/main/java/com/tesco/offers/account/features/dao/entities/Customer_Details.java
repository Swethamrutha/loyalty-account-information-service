/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.features.dao.entities;

import java.io.Serializable;
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
 * @Time:8:27:14 PM
 * @Description:Tesco Project
 */
@Entity
@Table(name="customer_details")
public class Customer_Details implements Serializable {

	private static final long serialVersionUID = -2216682169011989169L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private Integer id;
	
    @Column
    private String cardNumber;
    
    @Column
    private String cvv;
    
    @Column
    private String nameOnCard;
    
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

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

    
    


}
