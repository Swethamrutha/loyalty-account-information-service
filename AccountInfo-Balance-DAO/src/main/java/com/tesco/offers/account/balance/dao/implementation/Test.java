/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;
import com.tesco.offers.config.ConfigurationFile_Balance;

/**
 * @author:Tesco
 * @Date:Mar 2, 2019
 * @Time:7:03:10 PM
 * @Description:Tesco Project
 */

@Component
public class Test {
	
	
	



	public static void main(String[] args) throws BalanceBusinessException, BalanceSystemException {
		// TODO Auto-generated method stub
		
		
	
		
		
		
		
		
		
		
		
	ApplicationContext factory = new AnnotationConfigApplicationContext(ConfigurationFile_Balance.class);
		//System.out.println("llllllllPPPPPP::::::::::"+hibernateTemplate);
	
	
	
	
	String[] name = factory.getBeanDefinitionNames();
	
	for (String names : name) {
		System.out.println(names);
	}
	
	
	
	
	BalanceDAOImplementation balImpl = (BalanceDAOImplementation) factory.getBean("balanceDAOImplementation");
	
	
		System.out.println("############################################################################");
		System.out.println("Autowired from response :::"+balImpl);
		
		System.out.println("############################################################################");

		BalanceDaoRequest request = new BalanceDaoRequest();
		request.setClientid("web");
		request.setChannelid("online");
		request.setAccountnumber("1111222233334444");

		balImpl.getBalance(request);
		
	}

}
