package com.tesco.offers.account.process.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.features.dao.beans.AccountFeaturesDao;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAOResponse;
import com.tesco.offers.account.process.beans.AccountInfoProcessResponseBean;
import com.tesco.offers.account.process.beans.Balance;
import com.tesco.offers.account.process.beans.FeatureProcess;
import com.tesco.offers.account.process.beans.TaskResult;

public class AccountInfoProcessResponseBuilder {
	
	//prepare process response	
		AccountInfoProcessResponseBean processResp=new AccountInfoProcessResponseBean();
		
	Balance balance=new Balance() ;
	
	List<FeatureProcess> featureProcesslist=new ArrayList<FeatureProcess>();
	List<AccountFeaturesDao> daoFeatureList=null;
	List<String> linkedCards=new ArrayList<String>();
	

	public AccountInfoProcessResponseBean getProcessResponseBuilder(List<Future<TaskResult>> futurelist) throws InterruptedException, ExecutionException
	{
		System.out.println("size of list in builder::::::::"+futurelist);
		System.out.println("size of list in builder::::::::"+futurelist.size());
		System.out.println("coming to Process Builder");
		TaskResult result=null;
		
		
		
		for( Future tr:futurelist)
		{
			System.out.println("get list from future:::::::::"+tr.get());
			System.out.println("coming to Process Builder for loop");
			
			result=(TaskResult)tr.get();
			System.out.println("result::::::::::::"+result);
		
			if("balanceTask".equals(result.getTaskName()))
			{
				System.out.println("coming to Process Builder balance");
				BalanceDAOResponse balanceDaoResponse=(BalanceDAOResponse)result.getResult();
				System.out.println("Balance Dao Response in process:::"+balanceDaoResponse);
				
				if(balanceDaoResponse.getAvailablePts()!=0.0 && balanceDaoResponse.getBalanceAmt()!=0.0 && balanceDaoResponse.getCreditLimit()!=0 )
				{
				//System.out.println(balanceDaoResponse);
				System.out.println(balanceDaoResponse.getAvailablePts());
				//balance.setAvailablepts(45564);
				balance.setAvailablepts(balanceDaoResponse.getAvailablePts());
				balance.setCardBalance(balanceDaoResponse.getBalanceAmt());
				balance.setCreditLimit(balanceDaoResponse.getCreditLimit());
				}
				
				
			}
			
			else if("featureTask".equals(result.getTaskName()))
			{
				System.out.println("coming to Process Builder feature:::::::::::");
				
				
				FeaturesDaoResponse featureDaoResponse=(FeaturesDaoResponse)result.getResult();
				System.out.println("FeaturesDaoReseponse:::"+featureDaoResponse);
				
				 daoFeatureList = featureDaoResponse.getAccountfeatures();
			     System.out.println("getttingList in AccountFeaturesDao in process::::"+daoFeatureList);
			    // FeatureProcess featureProcess=new FeatureProcess();
			     
			     if(daoFeatureList!=null|| daoFeatureList.size()!=0|| featureDaoResponse.getAccountfeatures().size()!=0 )
			     {
			     for (AccountFeaturesDao accountFeaturesDao : daoFeatureList) {
			    	 FeatureProcess featureProcess=new FeatureProcess();
			    	 
					featureProcess.setCode(accountFeaturesDao.getCode());
					featureProcess.setDesc(accountFeaturesDao.getDesc());
					featureProcess.setIsEligibility(accountFeaturesDao.getIsEligibility());
					featureProcess.setExpiryDate(accountFeaturesDao.getExpiryDate());
					featureProcesslist.add(featureProcess);
					}
			  //   featureProcesslist.add(featureProcess);
				
				System.out.println("List in Process for feature::::::::"+featureProcesslist);
				}
			}
			
			else if("linkedCardTask".equals(result.getTaskName()))
			{
				System.out.println("coming to Process Builder linkedcards");
;
				CardsDAOResponse cardsDaoResponse=(	CardsDAOResponse)result.getResult();
				
				System.out.println("coming to feature process response builder::::::::"+cardsDaoResponse);

	              List<String> cardDaoList = cardsDaoResponse.getLinkedCards();

         System.out.println("cardDao::::::::"+cardDaoList);
					
					if(cardDaoList!=null)
					{
	             for (String cardslist : cardDaoList) {
	            	  linkedCards.add(cardslist) ;
	         
	             
				}  
					}
	             
				}

	}
System.out.println("Balance New Object:::"+balance);
System.out.println("Feature New Object:::"+featureProcesslist);
System.out.println("LinkedCards New Object:::"+linkedCards);

	
		processResp.setBalance(balance);
		processResp.setFeature(featureProcesslist);
		processResp.setLinkedCardrelation(linkedCards);
		processResp.setRespCode("000001");
		processResp.setUserMsg("Success");
		
		System.out.println("process Response Builder Class::::"+processResp);
		return processResp;
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
				
		
		
		
		
	}
	
	
	

}
