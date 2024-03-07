package com.tesco.offers.account.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.features.dao.beans.FeaturesDaoResponse;
import com.tesco.offers.account.features.dao.implementation.FeaturesDaoImplementation;


/* @CopyRight Tesco.All Rights are reserved */

/**
 * @author:Tesco
 * @Date:Feb 15, 2019
 * @Time:5:17:07 PM
 * @Description:Tesco Project
 */
   @Import({RepositoryConfig.class})
    
	@Configuration
	
	//@ImportResource("classpath:/config/applicationContextfeature.xml")
	@ComponentScan(basePackages={"com.tesco.offers.account.features.dao","com.tesco.offers.account.features.dao.implementation"})
	//@EnableTransactionManagement
	public class JavaConfiguration_Feature {
		
		@Bean
		
		public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
		{
			PropertyPlaceholderConfigurer pp=new PropertyPlaceholderConfigurer();
			pp.setLocation(new ClassPathResource("application.properties"));
			pp.setIgnoreUnresolvablePlaceholders(true);
			return pp;
			
		}
		
	
		
	//creating bean for Hibernate Transaction Manager
	/*	
			@Bean
			public HibernateTransactionManager getTransactionManager(SessionFactory d) throws IOException
			{
				HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
				hibernateTransactionManager.setSessionFactory(d);
			   return hibernateTransactionManager;
				
			}
			
			

			
*/}
