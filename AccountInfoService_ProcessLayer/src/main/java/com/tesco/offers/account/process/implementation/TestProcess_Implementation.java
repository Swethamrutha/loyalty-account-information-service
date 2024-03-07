/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.process.implementation;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.config.ConfigurationClass;
import com.tesco.offers.account.process.beans.AccountInfoProcessRequestBean;

/**
 * @author:Tesco
 * @Date:Mar 3, 2019
 * @Time:8:32:46 PM
 * @Description:Tesco Project
 */
public class TestProcess_Implementation {

	
	public TestProcess_Implementation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, BalanceBusinessException, BalanceSystemException, SQLException {
		// TODO Auto-generated method stub
		
		AccountInfoProcessRequestBean cc =new AccountInfoProcessRequestBean();
		cc.setAccountnumber("1111222233334444");
		cc.setChannelid("online");
		cc.setClientid("web");
		cc.setTypeofaccount("savings");
		
		ApplicationContext app=new AnnotationConfigApplicationContext(ConfigurationClass.class);
		            String[] names = app.getBeanDefinitionNames();
		            
		            for (String name : names) {
						System.out.println(name);
					}
		            
		
		System.out.println(app);
		AccountInfoProcessImplementation accountInfoProcessImplementation = app.getBean(AccountInfoProcessImplementation.class);
		accountInfoProcessImplementation.getAccount(cc);
	}

}
