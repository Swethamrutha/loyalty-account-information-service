package com.tesco.offers.account.linkedcard.dao.implentation;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;


import com.tesco.offers.account.linkedcard.config.LinkedCardConfigClass;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAOResponse;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardBusinessException;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardSystemException;
import com.tesco.offers.account.linkedcard.dao.interf.CardsDAO;
import com.tesco.offers.account.linkedcard.entities.Channel_Details;
import com.tesco.offers.account.linkedcard.entities.Client_Details;
import com.tesco.offers.account.linkedcard.entities.Customer_Details;
import com.tesco.offers.account.linkedcard.entities.LinkedCards_Info;

    @Component
    public class CardsDAOImplementation  implements CardsDAO{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	
	
	
	
	

	public CardsDAOResponse getAllCards(CardsDAORequest request)throws LinkedCardBusinessException, LinkedCardSystemException  {
		
		     CardsDAOResponse response=new CardsDAOResponse();
		     System.out.println("bean injection Linkedcard Dao:::::::"+hibernateTemplate);
		    
		     ApplicationContext factory = new AnnotationConfigApplicationContext(LinkedCardConfigClass.class);
		     hibernateTemplate = factory.getBean(HibernateTemplate.class);
		        
		
		     final List<Client_Details> listClientDetails = getClientDetails(request.getClientid());
		     
				if(listClientDetails.size()<1 || listClientDetails==null)
				{
					response.setStatusCode("100");
					response.setStatusMsg("InvalidClient");	
					
				}
				
				final	List<Channel_Details> listChannelDetails=getChannelDetails(request.getChannelid());
				if(listChannelDetails.size()<1 || listChannelDetails==null)
				{
					response.setStatusCode("101");
					response.setStatusMsg("Invalid ChannelId");	
				}
				
				
				final List<Customer_Details> listCustomerDetails = getCustomerDetails(request.getAccountnumber());
			    if(listCustomerDetails.size()<1 || listCustomerDetails==null)
				{
					response.setStatusCode("102");
					response.setStatusMsg("Invalid Customer");	
				}
				
			
				String hql="From LinkedCards_Info bal where bal.cardNumber=:card_num";
				final List<LinkedCards_Info> cardsList = getLinkedCards(request, response, hql);
				
				   if(cardsList==null || cardsList.size()<1)
					{
					response.setStatusCode("102");
			     	response.setStatusMsg("Invalid CardNumber");
					
					}
				
	               response.setStatusCode("0");
				response.setStatusMsg("success");
				System.out.println("final linked card dao response::::::::"+response);
					return response;
		
		
	}


  private List<LinkedCards_Info> getLinkedCards(CardsDAORequest request, CardsDAOResponse response, String hql) {
		
	  DetachedCriteria detachedCriteriabalance=DetachedCriteria.forClass(LinkedCards_Info.class);
		
		List<LinkedCards_Info> cardsList = (List<LinkedCards_Info>) hibernateTemplate.findByNamedParam(hql, new String[]{"card_num"}, new Object[]{request.getAccountnumber()});
		
		for (LinkedCards_Info linkedCards_Info : cardsList) {
		    	System.out.println(linkedCards_Info.getLinkedCards());
		    	String cardNum=linkedCards_Info.getLinkedCards();
		    	String[] cardNumSplit=cardNum.split(",");
		    	
		    	List<String> cardsAddList=new ArrayList<String>();
		    	
		    	for (String getCards : cardNumSplit) {
					
		    		System.out.println(getCards);
		    		cardsAddList.add(getCards);
				}
		    	
		    	response.setLinkedCards(cardsAddList);
			}
		
		System.out.println("last response:::::::::"+cardsList);
		
		return cardsList;
	}
	
  private List<Channel_Details> getChannelDetails(final String channelId)
	{
		DetachedCriteria detachedCriteriaChannel=DetachedCriteria.forClass(Channel_Details.class);
		detachedCriteriaChannel.add(Restrictions.eq("channel", channelId));
		return (List<Channel_Details>) hibernateTemplate.findByCriteria(detachedCriteriaChannel);
		
	}
	
	private List<Client_Details> getClientDetails(final String clientId) {
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Client_Details.class);
		System.out.println("detached Criteria::::"+detachedCriteria);
		detachedCriteria.add(Restrictions.eq("client", clientId));
		System.out.println("detached Criteria::::"+detachedCriteria);
		 List<Client_Details> listClientDetails = (List<Client_Details>) hibernateTemplate.findByCriteria(detachedCriteria);
		 System.out.println("listClientDetails:::::::::::"+listClientDetails.size());
		return listClientDetails;
	}
	
	 private List<Customer_Details> getCustomerDetails(final String accountNumber)
	{
		  DetachedCriteria detachedCriteriaCustomer=DetachedCriteria.forClass(Customer_Details.class);
			detachedCriteriaCustomer.add(Restrictions.eq("cardNumber", accountNumber));
			return (List<Customer_Details>) hibernateTemplate.findByCriteria(detachedCriteriaCustomer);
		
	}
	 
	 public static void main(String[] args) throws LinkedCardBusinessException, LinkedCardSystemException {
			// TODO Auto-generated method stub

			ApplicationContext app=new AnnotationConfigApplicationContext(LinkedCardConfigClass.class);
			String[] name = app.getBeanDefinitionNames();
		CardsDAOImplementation gg = app.getBean(CardsDAOImplementation.class);
		CardsDAORequest request =new CardsDAORequest();
		//System.out.println("Request Completed");

		request.setClientid("web");
		request.setChannelid("online");
		request.setAccountnumber("1111222233334444");
		
		gg.getAllCards(request);
			
			for (String getName : name) {
				System.out.println("::::::::::"+getName);
			}
			
			
			
			
		}

	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	
	
	
























	


