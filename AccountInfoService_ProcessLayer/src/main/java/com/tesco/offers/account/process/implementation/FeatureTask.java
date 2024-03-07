
package com.tesco.offers.account.process.implementation;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;
import com.tesco.offers.account.features.dao.implementation.FeaturesDaoImplementation;
import com.tesco.offers.account.features.dao.interf.FeaturesDao;
import com.tesco.offers.account.process.beans.TaskResult;

@Component
public class FeatureTask implements Callable<TaskResult>{

	private FeaturesDaoRequest featureRequest;
	
	public void setFeatureRequest(FeaturesDaoRequest featureRequest) {
		this.featureRequest = featureRequest;
	}
	
	@Autowired
	private FeaturesDaoImplementation featuresDaoImplementation;
	
	
	
/*FeatureTask(FeaturesDaoRequest featureRequest)
	{
		this.featureRequest=featureRequest;
	}*/
public TaskResult call() throws FeatureBusinessException,FeatureServiceException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
   System.out.println("Entered into Feature Task"); 
   System.out.println("bean injection in feature Task::::::::"+featuresDaoImplementation);
 // FeaturesDao featuredao=new FeaturesDaoImplementation();
	//FeaturesDaoResponse featureResp = featuredao.getAccountFeatures(featureRequest);
	
   FeaturesDaoResponse featureResp = featuresDaoImplementation.getAccountFeatures(featureRequest);
	System.out.println("feature resp....."+featureResp);
		
	TaskResult result=new TaskResult();
	
	result.setTaskName("featureTask");
	result.setResult(featureResp);
	System.out.println("Result of Feature:::::"+result);
	System.out.println("Exit from Feature Task");
		
	return result;
	}

}
