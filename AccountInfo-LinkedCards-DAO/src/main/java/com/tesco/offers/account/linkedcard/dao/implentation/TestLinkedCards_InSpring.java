/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.linkedcard.dao.implentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tesco.offers.account.linkedcard.config.LinkedCardConfigClass;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardBusinessException;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardSystemException;

/**
 * @author:Tesco
 * @Date:Mar 3, 2019
 * @Time:7:40:14 PM
 * @Description:Tesco Project
 */
public class TestLinkedCards_InSpring {

	
	public TestLinkedCards_InSpring() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws LinkedCardBusinessException, LinkedCardSystemException {
		// TODO Auto-generated method stub

		ApplicationContext app=new AnnotationConfigApplicationContext(LinkedCardConfigClass.class);
		String[] name = app.getBeanDefinitionNames();
	CardsDAOImplementation gg = app.getBean(CardsDAOImplementation.class);
	CardsDAORequest request =new CardsDAORequest();
	//System.out.println("Request Completed");

	request.setClientid("web");
	request.setChannelid("online");
	request.setAccountnumber("1111222233334444");
	
	gg.getAllCards(request);
		
		for (String getName : name) {
			System.out.println("::::::::::"+getName);
		}
		
		
		
		
	}

}
