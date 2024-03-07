/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.dao.implementation;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.offers.account.balance.dao.BalanceDAOInterface;
import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balance.entities.Balance_Info;
import com.tesco.offers.account.balance.entities.Channel_Details;
import com.tesco.offers.account.balance.entities.Client_Details;
import com.tesco.offers.account.balance.entities.Customer_Details;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;
import com.tesco.offers.config.ConfigurationFile_Balance;
//import org.springframework.orm.hibernate3.HibernateTemplate;
/**
 * @author:Tesco
 * @Date:Feb 5, 2019
 * @Time:11:52:30 AM
 * @Description:Tesco Project
 */

@Component
public class BalanceDAOImplementation implements BalanceDAOInterface {

	@Autowired
	private  HibernateTemplate hibernateTemplate;

	
	
	public BalanceDAOResponse getBalance(BalanceDaoRequest request) throws BalanceBusinessException, BalanceSystemException 
	
	{
		//this.request=request;
        BalanceDAOResponse balanceDAOResponse = new BalanceDAOResponse();
       
        System.out.println("bean injection balance Dao:::::::"+hibernateTemplate);
        String client = request.getClientid();
        System.out.println("bal::"+request.getAccountnumber());
        System.out.println("bal channel id::"+request.getChannelid());
       
    
    	List<Client_Details> listClientDetails = getClientDetails(request);
		
		// final List<Client_Details> listClientDetails = getClientDetails(request.getClientid());
	     
			if(listClientDetails.size()<1 || listClientDetails==null)
			{
				balanceDAOResponse.setRespCode("100");
				balanceDAOResponse.setRespMsg("InvalidClient");	
				
			}
		
		
			List<Channel_Details> listChannelDetails = getChannelDetails(request);
		
			//final List<Channel_Details> listChannelDetails = getChannelDetails();
		 if (listChannelDetails.size() < 1 || listChannelDetails == null) {
			balanceDAOResponse.setRespCode("101");
			balanceDAOResponse.setRespMsg("Invalid ChannelId");
		}

		   List<Customer_Details> listCustomerDetails = getCustomerDetails(request);
			
			if (listCustomerDetails.size() < 1 || listCustomerDetails == null) {
				balanceDAOResponse.setRespCode("102");
				balanceDAOResponse.setRespMsg("Invalid Customer");
			}
		 
		 
		 
		
		
		// getting details of balance information

		List<Balance_Info> listCustomerbalance = getBalanceDetails(request, balanceDAOResponse);
		if (listCustomerbalance == null ) {
			balanceDAOResponse.setRespCode("103");
			balanceDAOResponse.setRespMsg("Invalid Balance");

		}

		System.out.println("final balance dao response::::::::"+balanceDAOResponse);
		return balanceDAOResponse;
	}


	public List<Balance_Info> getBalanceDetails(BalanceDaoRequest request, BalanceDAOResponse balanceDAOResponse) {
		String hql = "From  Balance_Info bal where bal.cardNumber=:card_num";
		DetachedCriteria detachedCriteriabalance = DetachedCriteria.forClass(Balance_Info.class);
		// detachedCriteriabalance.add(Restrictions.eq("cardNumber",
		// request.getAccountnumber()));
		List<Balance_Info> listCustomerbalance = (List<Balance_Info>) hibernateTemplate.findByNamedParam(hql,new String[] { 

"card_num" }, new Object[] { request.getAccountnumber() });
		System.out.println("size of bal::::::::::"+listCustomerbalance);
		if (listCustomerbalance.size() == 1) {
			for (Balance_Info balance_Info : listCustomerbalance) {
		       balanceDAOResponse.setAvailablePts(balance_Info.getAvailablePoints());
				balanceDAOResponse.setBalanceAmt(balance_Info.getBalance());
				balanceDAOResponse.setCreditLimit(balance_Info.getCreditLimit());

			}
		}
		return listCustomerbalance;
	}


	public List<Customer_Details> getCustomerDetails(BalanceDaoRequest request) {
		DetachedCriteria detachedCriteriaCustomer = DetachedCriteria.forClass(Customer_Details.class);
			detachedCriteriaCustomer.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
			List<Customer_Details> listCustomerDetails = (List<Customer_Details>) hibernateTemplate.findByCriteria(detachedCriteriaCustomer);
		 
			System.out.println("size of customer in balance::"+listCustomerDetails.size());
		return listCustomerDetails;
	}


	public List<Channel_Details> getChannelDetails(BalanceDaoRequest request) {
		DetachedCriteria detachedCriteriaChannel = DetachedCriteria.forClass(Channel_Details.class);
		detachedCriteriaChannel.add(Restrictions.eq("channel", request.getChannelid()));
		List<Channel_Details> listChannelDetails = (List<Channel_Details>) hibernateTemplate.findByCriteria(detachedCriteriaChannel);
		System.out.println("list  Channel Details for balance:::::::::::"+listChannelDetails.size());
		return listChannelDetails;
	}


	public List<Client_Details> getClientDetails(BalanceDaoRequest request) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Client_Details.class);
		System.out.println("detached Criteria for Balance::::"+detachedCriteria);
		detachedCriteria.add(Restrictions.eq("client", request.getClientid()));
		System.out.println("detached Criteria  for Balance::::"+detachedCriteria);
		
		 List<Client_Details> listClientDetails = (List<Client_Details>) hibernateTemplate.findByCriteria(detachedCriteria);
		 System.out.println("listClientDetails for balance:::::::::::"+listClientDetails.size());
		return listClientDetails;
	}

	
	
	
	
	
	
	
	

}
