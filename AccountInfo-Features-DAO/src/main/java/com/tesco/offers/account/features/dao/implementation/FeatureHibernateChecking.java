/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.features.dao.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


//import com.tesco.offers.account.balance.utils.HibernateUtils;
import com.tesco.offers.account.features.dao.beans.AccountFeaturesDao;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.entities.Features_info;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;
//import com.tesco.offers.account.service.entities.Channel_Details;
//import com.tesco.offers.account.service.entities.Client_Details;
//import com.tesco.offers.account.service.entities.Customer_Details;

/**
 * @author:Tesco
 * @Date:Feb 5, 2019
 * @Time:1:38:02 PM
 * @Description:Tesco Project
 */
public class FeatureHibernateChecking {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws BalanceSystemException 
	 * @throws BalanceBusinessException 
	 * @throws ClassNotFoundException 
	 */
	
		
	public FeaturesDaoResponse getAccountFeatures(FeaturesDaoRequest request)
			throws FeatureBusinessException, FeatureServiceException  {
		
		System.out.println("entered into method");
		
		FeaturesDaoResponse response=new FeaturesDaoResponse();
		/*SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		System.out.println("SessionFactory::::::::"+sessionFactory);
		
		Session session=sessionFactory.openSession();
		
		//getting list of client
		Criteria criteria=session.createCriteria(Client_Details.class);
		criteria.add(Restrictions.eq("client", request.getClientid()));
	    List<Client_Details> clientList = criteria.list();
	    System.out.println("list in client::"+clientList);
		
	    for (Client_Details client_Details : clientList) {
			System.out.println(client_Details.getClient());
		}
	    
	    
	    if(clientList==null)
		{
		response.setStatusCode("100");
		response.setStatusMsg("InvalidClient");
		
		}
		
	   //getting list of channel
	    Criteria criteria1=session.createCriteria(Channel_Details.class);
		criteria1.add(Restrictions.eq("channel", request.getChannelid()));
	    List<Channel_Details> channelList = criteria1.list();
		
	    
	    for (Channel_Details channel_Details : channelList) {
			System.out.println(channel_Details.getChannel());
		}
	    if(channelList==null)
		{
		response.setStatusCode("101");
		response.setStatusMsg("Invalid ChannelId");
		throw new FeatureBusinessException(response.getStatusCode(),response.getStatusMsg());
		}
	    
	    //getting list of customer
	    
	    Criteria criteria2=session.createCriteria(Customer_Details.class);
		criteria2.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
	    List<Customer_Details> customerList = criteria2.list();
		
	    
	    for (Customer_Details customer_Details : customerList) {
			System.out.println(customer_Details.getCardNumber());
		}
	    if(customerList==null)
		{
	    	
		response.setStatusCode("102");
     	response.setStatusMsg("Invalid CardNumber");
		
		}
	    
	    //getting list of feature
	    
	    Criteria featurescriteria=session.createCriteria(Features_info.class);
	    featurescriteria.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
	    List<Features_info> featureList = featurescriteria.list();
	    System.out.println("List in feature::"+featureList);
	    List<AccountFeaturesDao> accountfeatures=new ArrayList<AccountFeaturesDao>();
		 
	    
	    for (Features_info features_info : featureList) {
	    	System.out.println("coming to for loop");
			System.out.println(features_info.getCardNumber());
			System.out.println(features_info.getCode());
			System.out.println(features_info.getDesc());
			System.out.println(features_info.getExpiryDate());
			
			    AccountFeaturesDao accountFeaturesDao=new AccountFeaturesDao();
			   
			accountFeaturesDao.setCode(features_info.getCode());
			accountFeaturesDao.setDesc(features_info.getDesc());
			accountFeaturesDao.setEligibility(features_info.isEligible());
			accountFeaturesDao.setExpiryDate(features_info.getExpiryDate());
			accountfeatures.add(accountFeaturesDao);
			
			}
	    response.setAccountfeatures(accountfeatures);
		
	    
	    if(featureList==null)
		{
		response.setStatusCode("102");
     	response.setStatusMsg("Invalid CardNumber");
		
		}
    
		response.setStatusCode("0");
		response.setStatusMsg("success");
		
*/		return response;
	}

	public static void main(String[] args) throws FeatureBusinessException, FeatureServiceException{
		// TODO Auto-generated method stub
    System.out.println("Main Method");
	System.out.println("Request Completed");

	FeaturesDaoRequest request =new FeaturesDaoRequest();
	//System.out.println("Request Completed");

	request.setClientid("web");
	request.setChannelid("online");
	request.setAccountnumber("1111222233334444");
	
	//System.out.println("Request Completed");
	FeatureHibernateChecking hibernateChecking=new FeatureHibernateChecking();
	FeaturesDaoResponse FeaturesDaoResponse=hibernateChecking.getAccountFeatures(request);
	System.out.println(FeaturesDaoResponse);
	
	
		}

	
	
	
	
	
	
	

}
