/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.web;

import org.springframework.stereotype.Component;

/**
 * @author:Tesco
 * @Date:Mar 6, 2019
 * @Time:11:29:14 AM
 * @Description:Tesco Project
 */
@Component
public class DaoClass {

	public Customer cusadd()
	{
		Customer cc=new Customer();
		cc.setId(1l);
		cc.setFirstname("swetha");
		cc.setLastname("ammu");
		return cc;
		
	}

}
