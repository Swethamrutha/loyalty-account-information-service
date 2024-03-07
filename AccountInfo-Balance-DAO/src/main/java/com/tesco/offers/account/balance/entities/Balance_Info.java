/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author:Tesco
 * @Date:Feb 4, 2019
 * @Time:7:41:57 PM
 * @Description:Tesco Project
 */

@Entity
@Table(name="balance_info")
public class Balance_Info implements Serializable {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Balance_Info [id=" + id + ", cardNumber=" + cardNumber + ", balance=" + balance + ", creditLimit="
				+ creditLimit + ", availablePoints=" + availablePoints + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private Integer id;
	
	@Column
	private String cardNumber;
	
	@Column
	private double balance;
	
	@Column
	private double creditLimit;
	
	@Column
	private Long availablePoints;

	public Long getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(Long availablePoints) {
		this.availablePoints = availablePoints;
	}

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

	
	
	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

		
	
	
	
	
	
	
	

}
