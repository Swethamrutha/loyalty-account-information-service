package com.tesco.offers.account.linkedcard.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="linkedcards_info")
public class LinkedCards_Info implements Serializable {

	private static final long serialVersionUID = 5689473456613773107L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private Integer id;
	
	@Column
	private String cardNumber;
	
	@Column
	private String linkedCards;

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

	public String getLinkedCards() {
		return linkedCards;
	}

	public void setLinkedCards(String linkedCards) {
		this.linkedCards = linkedCards;
	}
	
	
	
	
	
	
	
	
	

}
