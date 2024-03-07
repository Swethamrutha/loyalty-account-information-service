package com.tesco.offers.account.process.builder;

import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
import com.tesco.offers.account.process.beans.AccountInfoProcessRequestBean;
import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceRequest;

public class AccountInfoProcessRequestBuilder {
	
	//preparing card verfication request
	
	public CardVerifyServiceRequest getCardVerificationApi(AccountInfoProcessRequestBean processrequest)
	{
		//get the request from svc layer
		//prepare request for cardverify service
		CardVerifyServiceRequest cardVerifyServiceRequest=new CardVerifyServiceRequest();
		cardVerifyServiceRequest.setCardnumber(processrequest.getAccountnumber());
		cardVerifyServiceRequest.setChannelid(processrequest.getChannelid());
		cardVerifyServiceRequest.setClientid(processrequest.getClientid());
		return cardVerifyServiceRequest;
		}
	
	//preaparing Balanace Dao request and sending request to balance
	
	public BalanceDaoRequest getBalanceRequest(AccountInfoProcessRequestBean processrequest)
	{
		//prepare Balance Dao Request
		 BalanceDaoRequest balancedaoRequest=new BalanceDaoRequest();
		balancedaoRequest.setAccountnumber(processrequest.getAccountnumber());
		balancedaoRequest.setChannelid(processrequest.getChannelid());
		balancedaoRequest.setClientid(processrequest.getClientid());
	  return balancedaoRequest;
	}
	
	//preparing Feature Dao request and sending request to feature
	
	public FeaturesDaoRequest getFeaturesDaoRequest(AccountInfoProcessRequestBean processrequest)
	{
		//prepare Feature Dao Request
		FeaturesDaoRequest featuredaoRequest=new FeaturesDaoRequest();
		featuredaoRequest.setAccountnumber(processrequest.getAccountnumber());
		featuredaoRequest.setChannelid(processrequest.getChannelid());
		featuredaoRequest.setClientid(processrequest.getClientid());
		return featuredaoRequest;
		
	}
	
	//preparing LinkedCardDao Request and Sending request to LinkedCard
	
	public CardsDAORequest getLinkedCardsDAORequest(AccountInfoProcessRequestBean processrequest)
	{
		//prepare LinkedCard Dao Request
		CardsDAORequest linkedcardDaoReq=new CardsDAORequest();
		linkedcardDaoReq.setAccountnumber(processrequest.getAccountnumber());
		linkedcardDaoReq.setChannelid(processrequest.getChannelid());
		linkedcardDaoReq.setClientid(processrequest.getClientid());
		return linkedcardDaoReq;
		
	}
	

}
