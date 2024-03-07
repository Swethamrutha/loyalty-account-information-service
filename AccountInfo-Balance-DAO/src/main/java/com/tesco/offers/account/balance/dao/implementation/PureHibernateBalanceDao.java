/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.dao.implementation;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.tesco.offers.account.balance.dao.BalanceDAOInterface;
import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balance.entities.Balance_Info;
import com.tesco.offers.account.balance.entities.Channel_Details;
import com.tesco.offers.account.balance.entities.Client_Details;
import com.tesco.offers.account.balance.entities.Customer_Details;
import com.tesco.offers.account.balance.utils.HibernateUtils;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;



/**
 * @author:Tesco
 * @Date:Feb 5, 2019
 * @Time:11:52:30 AM
 * @Description:Tesco Project
 */
public class PureHibernateBalanceDao  implements BalanceDAOInterface {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws BalanceSystemException 
	 * @throws BalanceBusinessException 
	 * @throws ClassNotFoundException 
	 */
	
   private HibernateTemplate hibernateTemplate=null;
	public PureHibernateBalanceDao()
	{
		System.out.println("Balance Dao Implementation Constructor");
		ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		DriverManagerDataSource ff =(DriverManagerDataSource)factory.getBean("dataSource");
		System.out.println(ff);
		
		 Object ll = factory.getBean("sessionFactory");
		System.out.println(ll);
		
		hibernateTemplate=(HibernateTemplate) factory.getBean("hibernateTemplate");
		System.out.println(hibernateTemplate);
		             
		/*
		appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("ApplicationContext Object::::::::::"+appContext);
		hibernateTemplate=appContext.getBean("hibernateTemplate", HibernateTemplate.class);
		System.out.println("hibernateTemplate::::::::::"+hibernateTemplate);
		
		
		*/
	}
	
	public BalanceDAOResponse getBalance(BalanceDaoRequest request)
			throws BalanceBusinessException, BalanceSystemException  {
		BalanceDAOResponse response=new BalanceDAOResponse();
		System.out.println("entered into method");
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
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
		response.setRespCode("100");
		response.setRespMsg("InvalidClient");
		
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
		response.setRespCode("101");
		response.setRespMsg("Invalid ChannelId");
		throw new BalanceBusinessException(response.getRespCode(),response.getRespMsg());
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
	    	
		response.setRespCode("102");
     	response.setRespMsg("Invalid CardNumber");
		
		}
	    
	    //getting list of balance
	    
	    Criteria balcriteria=session.createCriteria(Balance_Info.class);
		balcriteria.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
	    List<Balance_Info> balanceList = balcriteria.list();
		
	    
	    for (Balance_Info balance_Info : balanceList) {
	    	System.out.println("coming to for loop");
			System.out.println(balance_Info.getAvailablePoints());
			
			response.setAvailablePts(balance_Info.getAvailablePoints());
			response.setBalanceAmt(balance_Info.getBalance());
			response.setCreditLimit(balance_Info.getCreditLimit());
			//response.setCreditLimit(balance_Info.getCreditLimit());
			}
	    
	    
	    if(balanceList==null)
		{
		response.setRespCode("102");
     	response.setRespMsg("Invalid CardNumber");
		
		}
    
		response.setRespCode("0");
		response.setRespMsg("success");
		
		return response;
	}

	public static void main(String[] args) throws ClassNotFoundException, BalanceBusinessException, BalanceSystemException, SQLException {
		// TODO Auto-generated method stub
    System.out.println("Main Method");
	System.out.println("Request Completed");

    BalanceDaoRequest request =new BalanceDaoRequest();
	System.out.println("Request Completed");

	request.setClientid("web");
	request.setChannelid("online");
	request.setAccountnumber("1111222233334444");
	
	//System.out.println("Request Completed");
	BalanceDAOImplementation hibernateChecking=new BalanceDAOImplementation();
	BalanceDAOResponse balanceDAOResponse=hibernateChecking.getBalance(request);
	System.out.println(balanceDAOResponse);
	
	
		}

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
