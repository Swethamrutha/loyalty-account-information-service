/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tesco.offers.account.config.JavaConfiguration_Feature;
import com.tesco.offers.cardverifyservice.config.Config_CardVerifyService;
import com.tesco.offers.config.ConfigurationFile_Balance;
import com.tesco.offers.service.config.ConfigurationSpringRest;

/**
 * @author:Tesco
 * @Date:Mar 4, 2019
 * @Time:9:52:44 AM
 * @Description:Tesco Project
 */

@Configuration

@EnableWebMvc
@Import({ JavaConfiguration_Feature.class,ConfigurationSpringRest.class,Config_CardVerifyService.class,ConfigurationFile_Balance.class })

@ComponentScan(basePackages={"com.tesco.offers.account.balances.dao","com.tesco.offers.account.service.implementation","com.tesco.offers.account.balance.dao.implementation","com.tesco.offers.account.features.dao.implementation","com.tesco.offers.account.features.dao.interf"})
public class AllConfiguration {
	
	
	
	
	public static void main(String[] args) {
		ApplicationContext app=new AnnotationConfigApplicationContext(AllConfiguration.class);	
		System.out.println(app.getBeanDefinitionCount());
		String[] gg = app.getBeanDefinitionNames();
		for (String string : gg) {
			System.out.println(string);
		}
		
System.out.println(app);
	}

}
