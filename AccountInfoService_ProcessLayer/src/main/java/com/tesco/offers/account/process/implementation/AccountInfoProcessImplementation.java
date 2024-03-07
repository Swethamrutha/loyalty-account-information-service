 package com.tesco.offers.account.process.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balance.dao.implementation.BalanceDAOImplementation;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardBusinessException;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardSystemException;
import com.tesco.offers.account.process.AccountInfoProcess;
import com.tesco.offers.account.process.beans.AccountInfoProcessRequestBean;
import com.tesco.offers.account.process.beans.AccountInfoProcessResponseBean;
import com.tesco.offers.account.process.beans.Balance;
import com.tesco.offers.account.process.beans.FeatureProcess;
import com.tesco.offers.account.process.beans.TaskResult;
import com.tesco.offers.account.process.builder.AccountInfoProcessRequestBuilder;
import com.tesco.offers.account.process.builder.AccountInfoProcessResponseBuilder;
/*import com.tesco.offers.account.process.AccountInfoProcess;
import com.tesco.offers.account.process.beans.AccountInfoProcessRequestBean;
import com.tesco.offers.account.process.beans.AccountInfoProcessResponseBean;
import com.tesco.offers.account.process.beans.Balance;
import com.tesco.offers.account.process.beans.FeatureProcess;
import com.tesco.offers.account.process.beans.TaskResult;
import com.tesco.offers.account.process.builder.AccountInfoProcessRequestBuilder;
import com.tesco.offers.account.process.builder.AccountInfoProcessResponseBuilder;*/
/*import com.tesco.offers.account.process.AccountInfoProcess;
import com.tesco.offers.account.process.beans.AccountInfoProcessRequestBean;
import com.tesco.offers.account.process.beans.AccountInfoProcessResponseBean;
import com.tesco.offers.account.process.beans.Balance;
import com.tesco.offers.account.process.beans.FeatureProcess;
import com.tesco.offers.account.process.beans.TaskResult;
import com.tesco.offers.account.process.builder.AccountInfoProcessRequestBuilder;
import com.tesco.offers.account.process.builder.AccountInfoProcessResponseBuilder;*/
import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceRequest;
import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceResponse;
import com.tesco.offers.cardverifyservice.client.implementation.CardVerifyServiceClientImplementation;
import com.tesco.offers.cardverifyservice.client.interf.CardVerifyServiceClient;

@Component
public class AccountInfoProcessImplementation implements AccountInfoProcess {

@Autowired
private CardVerifyServiceClientImplementation cardVerifyServiceClientImplementation;

@Autowired
private BalanceTask balanceTask;

@Autowired
private FeatureTask featureTask;


@Autowired
private LinkedCardTask linkedCardTask;



/*
@Autowired	
public AccountInfoProcessImplementation(CardVerifyServiceClientImplementation cardVerifyServiceClientImplementation)
{
	this.cardVerifyServiceClientImplementation=cardVerifyServiceClientImplementation;
}

*/




 

public AccountInfoProcessResponseBean getAccount(AccountInfoProcessRequestBean processrequest) throws InterruptedException 
		// TODO Auto-generated method stub
, ClassNotFoundException, BalanceBusinessException, BalanceSystemException, SQLException
		
		
	{
		
		
		
		AccountInfoProcessResponseBean processResp=null;
		try{	
	//prepare process response	
       processResp=new AccountInfoProcessResponseBean();
	
	Balance balance=new Balance() ;
	List<FeatureProcess> featureProcesslist=new ArrayList<FeatureProcess>();
	List<String> linkedCards=new ArrayList<String>();
	

	//call the process request builder for cardverificationRequest
	AccountInfoProcessRequestBuilder accountInfoProcessRequestBuilder=new AccountInfoProcessRequestBuilder();
	
	CardVerifyServiceRequest cardVerifyServiceRequest=accountInfoProcessRequestBuilder.getCardVerificationApi( processrequest);
	
	System.out.println("Checking card in process::::::::::::"+cardVerifyServiceClientImplementation);
	System.out.println("Checking balanecTeask::::::::::::"+balanceTask);
	
	
	//call service client for cardVerification
	
	
	CardVerifyServiceClientImplementation cardVerifyServiceClientImplementation=new CardVerifyServiceClientImplementation();
	CardVerifyServiceResponse clientResponse=cardVerifyServiceClientImplementation.verifyCard(cardVerifyServiceRequest);
	
	//call the process request Builder for BalanceDaoRequest
	BalanceDaoRequest balancedaoRequest=accountInfoProcessRequestBuilder.getBalanceRequest(processrequest);
	System.out.println("balancedaorequest:::::::"+balancedaoRequest);
	
	//call the process request Builder for FeatureDaoRequest
		FeaturesDaoRequest featuredaoRequest=accountInfoProcessRequestBuilder.getFeaturesDaoRequest(processrequest);
		
	
	//call the process request builder for LinkedCardsDaoRequest
	CardsDAORequest linkedcardDaoReq=accountInfoProcessRequestBuilder.getLinkedCardsDAORequest(processrequest);
	System.out.println("get data from LinkedCards::::::::"+linkedcardDaoReq);
	


	System.out.println("************************************"+balancedaoRequest);

	
	if(clientResponse.isValid())
	{
	ExecutorService svc=Executors.newFixedThreadPool(3);
	System.out.println("coming to if::::::::::");
	
	/* tasks.add(new BalanceTask(balancedaoRequest));
	tasks.add(new FeatureTask(featuredaoRequest));
	tasks.add(new LinkedCardTask(linkedcardDaoReq));*/
	List list=new ArrayList();

	//tasks.add(balanceTask.setDaoRequest1(balancedaoRequest));
	System.out.println("************************************"+balancedaoRequest);
	
	balanceTask.setDaoRequest1(balancedaoRequest);
	featureTask.setFeatureRequest(featuredaoRequest);
	linkedCardTask.setLinkedCardRequest(linkedcardDaoReq);
	Set tasks=new HashSet();
	
	tasks.add(balanceTask);
	tasks.add(featureTask);
	tasks.add(linkedCardTask);
	
	
	
	
	List<Future<TaskResult>> futurelist=svc.invokeAll(tasks);
	
	
	//call the  process response builder
		AccountInfoProcessResponseBuilder accountInfoProcessResponseBuilder=new AccountInfoProcessResponseBuilder();
		processResp=accountInfoProcessResponseBuilder.getProcessResponseBuilder(futurelist);
		
		
		
		
		
		
}
	
	System.out.println("Process Exit::::::::::"+processResp);
	
	}
    catch(ExecutionException e)
		{
	
    	if(e.getCause() instanceof BalanceBusinessException)
    	{
    		BalanceBusinessException bbe=(BalanceBusinessException)e.getCause();
    		System.out.println("bbe::::: "+bbe.getRespCode());
    		
    		processResp.setRespCode(bbe.getRespCode());
    		processResp.setUserMsg(bbe.getRespMsg());
    	}
    	else if(e.getCause() instanceof BalanceSystemException)
    	{
    		
    		BalanceSystemException bse=(BalanceSystemException)e.getCause();
    		System.out.println("bse::::: "+bse.getRespCode());
    		
    		processResp.setRespCode(bse.getRespCode());
    		processResp.setUserMsg(bse.getRespMsg());
    	}
    	else if(e.getCause() instanceof FeatureBusinessException)
    	{
    		FeatureBusinessException fbe=(FeatureBusinessException)e.getCause();
    		processResp.setRespCode(fbe.getRespCode());
    		processResp.setUserMsg(fbe.getRespMsg());
    		
    	}
    	else if(e.getCause() instanceof FeatureServiceException)
    	{
    		FeatureServiceException fse = (FeatureServiceException)e.getCause();
    		processResp.setRespCode(fse.getRespCode());
    		processResp.setUserMsg(fse.getRespMsg());
    	}
    	else if(e.getCause() instanceof LinkedCardBusinessException)
    	{
    		LinkedCardBusinessException lbe=(LinkedCardBusinessException)e.getCause();
    		processResp.setRespCode(lbe.getRespCode());
    		processResp.setUserMsg(lbe.getRespMsg());
    		
    	}
    	else if(e.getCause() instanceof LinkedCardSystemException)
    	{
    		LinkedCardSystemException lse= (LinkedCardSystemException)e.getCause(); 
    		processResp.setRespCode(lse.getRespCode());
    		processResp.setUserMsg(lse.getRespMsg());
    	}
    	else if(e.getCause() instanceof NullPointerException)
    	{
    		processResp.setRespCode("0");
    		processResp.setUserMsg("null");
    
    		
    	}
   }
	
		return processResp;
	}

	
public static void main(String[] args) throws InterruptedException, ClassNotFoundException, BalanceBusinessException, BalanceSystemException, SQLException 
	{
	
	AccountInfoProcessRequestBean cc =new AccountInfoProcessRequestBean();
	cc.setAccountnumber("1111222233334444");
	cc.setChannelid("online");
	cc.setClientid("web");
	cc.setTypeofaccount("savings");
	
	
	
	AccountInfoProcessResponseBean processResp=new AccountInfoProcessResponseBean();
		AccountInfoProcessImplementation gg=new AccountInfoProcessImplementation();
		AccountInfoProcessRequestBean processrequest=new AccountInfoProcessRequestBean();
		AccountInfoProcessResponseBean bb =gg.getAccount(cc);
		System.out.println("Process Response Bean:::::::::::::::"+bb);

			}



	

}
