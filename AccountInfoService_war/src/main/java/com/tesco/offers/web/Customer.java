/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.web;

import org.springframework.stereotype.Component;

/**
 * @author:Tesco
 * @Date:Mar 6, 2019
 * @Time:11:26:51 AM
 * @Description:Tesco Project
 */

@Component
public class Customer {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	private Long id;
	private String firstname;
	private String lastname;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	
	
	
	

}
