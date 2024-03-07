
package com.tesco.offers.account.features.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balance.utils.HibernateUtils;
import com.tesco.offers.account.config.JavaConfiguration_Feature;
import com.tesco.offers.account.features.dao.beans.AccountFeaturesDao;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoRequest;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.entities.Channel_Details;
import com.tesco.offers.account.features.dao.entities.Client_Details;
import com.tesco.offers.account.features.dao.entities.Customer_Details;
import com.tesco.offers.account.features.dao.entities.Features_info;
import com.tesco.offers.account.features.dao.exception.FeatureBusinessException;
import com.tesco.offers.account.features.dao.exception.FeatureServiceException;
import com.tesco.offers.account.features.dao.interf.FeaturesDao;
import com.tesco.offers.config.ConfigurationFile_Balance;

@Component
public class FeaturesDaoImplementation implements FeaturesDao {

	//@Autowired
	//@Qualifier("hibernatefeature")
	private HibernateTemplate hibernateTemplatefeature;

	private final Logger logger=Logger.getLogger(FeaturesDaoImplementation.class);
	public FeaturesDaoResponse getAccountFeatures(FeaturesDaoRequest request)throws FeatureBusinessException, FeatureServiceException {
		
		FeaturesDaoResponse response = new FeaturesDaoResponse();
		
		ApplicationContext factory = new AnnotationConfigApplicationContext(JavaConfiguration_Feature.class);
		hibernateTemplatefeature =factory.getBean(HibernateTemplate.class);
	    logger.info(request);
	    logger.info("bean injection in feature:::"+hibernateTemplatefeature);
		
		
	    
	    List<Client_Details> listClientDetails = getClientDetails(request);

		if (listClientDetails.size() < 1 || listClientDetails == null) {
			response.setStatusCode("100");
			response.setStatusMsg("InvalidClient");

		}

	
		List<Channel_Details> listChannelDetails = getChannelDetails(request);

		if (listChannelDetails.size() < 1 || listChannelDetails == null) {
			response.setStatusCode("101");
			response.setStatusMsg("Invalid ChannelId");
		}

		
		List<Customer_Details> listCustomerDetails = getCustomerDetails(request);

		if (listCustomerDetails.size() < 1 || listCustomerDetails == null) {
			response.setStatusCode("102");
			response.setStatusMsg("Invalid Customer");
		}

		

		List<Features_info> listCustomerfeature = getFeatureInfo(request, response);

		if (listCustomerfeature == null) {
			response.setStatusCode("103");
			response.setStatusMsg("Invalid Features");

		}
		
		
		response.setStatusCode("0");
		response.setStatusMsg("success");

		
		return response;
	}

	public List<Features_info> getFeatureInfo(FeaturesDaoRequest request, FeaturesDaoResponse response) {
		String hql = "From  Features_info bal where bal.cardNumber=:card_num";
		DetachedCriteria detachedCriteriabalance = DetachedCriteria.forClass(Features_info.class);

		List<Features_info> listCustomerfeature = (List<Features_info>) hibernateTemplatefeature.findByNamedParam(hql,new String[] { "card_num" }, new Object[] { request.getAccountnumber() });

		List<AccountFeaturesDao> accountfeatures = new ArrayList<AccountFeaturesDao>();

		for (Features_info features_info : listCustomerfeature) {

			AccountFeaturesDao accountFeaturesDao = new AccountFeaturesDao();
			accountFeaturesDao.setCode(features_info.getCode());
			accountFeaturesDao.setDesc(features_info.getDesc());
			accountFeaturesDao.setEligibility(features_info.isEligible());
			accountFeaturesDao.setExpiryDate(features_info.getExpiryDate());
			accountfeatures.add(accountFeaturesDao);

		}
		response.setAccountfeatures(accountfeatures);
		return listCustomerfeature;
	}

	public List<Customer_Details> getCustomerDetails(FeaturesDaoRequest request) {
		DetachedCriteria detachedCriteriaCustomer = DetachedCriteria.forClass(Customer_Details.class);
		detachedCriteriaCustomer.add(Restrictions.eq("cardNumber", request.getAccountnumber()));
		List<Customer_Details> listCustomerDetails = (List<Customer_Details>) hibernateTemplatefeature.findByCriteria(detachedCriteriaCustomer);
		return listCustomerDetails;
	}

	public List<Channel_Details> getChannelDetails(FeaturesDaoRequest request) {
		DetachedCriteria detachedCriteriaChannel = DetachedCriteria.forClass(Channel_Details.class);
		detachedCriteriaChannel.add(Restrictions.eq("channel", request.getChannelid()));
		List<Channel_Details> listChannelDetails = (List<Channel_Details>) hibernateTemplatefeature.findByCriteria(detachedCriteriaChannel);
		return listChannelDetails;
	}

	public List<Client_Details> getClientDetails(FeaturesDaoRequest request) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Client_Details.class);
		detachedCriteria.add(Restrictions.eq("client", request.getClientid()));
		List<Client_Details> listClientDetails = (List<Client_Details>) hibernateTemplatefeature.findByCriteria(detachedCriteria);
         return listClientDetails;
	}

	public static void main(String[] args)
			throws BalanceBusinessException, BalanceSystemException, FeatureBusinessException, FeatureServiceException {
		// TODO Auto-generated method stub
		ApplicationContext factory = new AnnotationConfigApplicationContext(JavaConfiguration_Feature.class);

		String[] name = factory.getBeanDefinitionNames();

		for (String names : name) {
			System.out.println(names);
		}

		FeaturesDaoImplementation featureImpl = (FeaturesDaoImplementation) factory
				.getBean("featuresDaoImplementation");

		System.out.println("############################################################################");
		System.out.println("Autowired from response :::" + featureImpl);

		System.out.println("############################################################################");

		FeaturesDaoRequest request = new FeaturesDaoRequest();

		request.setClientid("web");
		request.setChannelid("online");
		request.setAccountnumber("1111222233334444");
		featureImpl.getAccountFeatures(request);

	}

}
