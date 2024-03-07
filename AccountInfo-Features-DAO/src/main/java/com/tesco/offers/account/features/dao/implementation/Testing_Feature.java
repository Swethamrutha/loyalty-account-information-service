package com.tesco.offers.account.features.dao.implementation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.config.JavaConfiguration_Feature;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;


public class Testing_Feature {

	public Testing_Feature() {
		// TODO Auto-generated constructor stub
	}


	 public static void main(String[] args) throws BalanceBusinessException, BalanceSystemException, FeatureBusinessException, FeatureServiceException {
 		// TODO Auto-generated method stub
 	ApplicationContext factory = new AnnotationConfigApplicationContext(JavaConfiguration_Feature.class);
 		
 	String[] name = factory.getBeanDefinitionNames();
 	
 	for (String names : name) {
 		System.out.println(names);
 	}
 	
 	
 	
 	
 	FeaturesDaoImplementation featureImpl = (FeaturesDaoImplementation) factory.getBean("featuresDaoImplementation");
 	
 	
 		System.out.println("############################################################################");
 		System.out.println("Autowired from response :::"+featureImpl);
 		
 		System.out.println("############################################################################");

 		FeaturesDaoRequest request =new FeaturesDaoRequest();
 		
 		request.setClientid("web");
 		request.setChannelid("online");
 		request.setAccountnumber("1111222233334444");
 		featureImpl.getAccountFeatures(request);
 		
 	}
	
}
