/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.linkedcard.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tesco.offers.account.balance.dao.implementation.BalanceDAOImplementation;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;



/**
 * @author:Tesco
 * @Date:Feb 14, 2019
 * @Time:4:56:47 PM
 * @Description:Tesco Project
 */


//creating configuration

@Configuration

//@ImportResource("classpath:/config/applicationContext.xml")
@ComponentScan(basePackages={"com.tesco.offers.account.linkedcard.dao.implentation","com.tesco.offers.account.linkedcard.dao.interf"})
/*@EnableTransactionManagementcom.tesco.offers.account
*/
public class ConfigurationFile_Cards {

	
   //creating bean for datasource
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/swethaRTP4223");
		datasource.setUsername("root");
		datasource.setPassword("root");
		return datasource;
		
	}
	
	//creating bean for sessionfactory
	
	@Bean
	public SessionFactory  sessionFactory(DataSource d) throws IOException
	{
		LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
		sessionfactory.setPackagesToScan("com.tesco.offers.account.linkedcard.entities");
		sessionfactory.setDataSource(d);
		sessionfactory.setHibernateProperties(hibernateProperties());
		sessionfactory.afterPropertiesSet();
		return sessionfactory.getObject();
		
	}
	
	//creating bean for Hibernate Transaction Manager
	
	/*@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory d) throws IOException
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(d);
	   return hibernateTransactionManager;
		
	}*/
	
	//creating bean for hibernate Template
	@Bean
	
	public HibernateTemplate hibernateTemplate(SessionFactory d) throws IOException
	{
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(d);
		return hibernateTemplate;
		
	}
	
	private static Properties hibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		return properties;
		
	}
	
	
}
	
	
	