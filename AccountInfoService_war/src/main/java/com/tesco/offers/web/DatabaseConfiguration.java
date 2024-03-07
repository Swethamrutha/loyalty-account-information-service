/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.web;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author:Tesco
 * @Date:Mar 11, 2019
 * @Time:9:43:55 AM
 * @Description:Tesco Project
 */
@Configuration
public class DatabaseConfiguration {

	@Bean
	@Scope("prototype")
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
	@Scope("prototype")
	public SessionFactory  sessionFactory(DataSource d) throws IOException
	{
		LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
		sessionfactory.setPackagesToScan("com.tesco.offers.account.balance.entities");
		sessionfactory.setDataSource(d);
		sessionfactory.setHibernateProperties(hibernateProperties());
		sessionfactory.afterPropertiesSet();
		return sessionfactory.getObject();
		
	}
	
	/*//creating bean for Hibernate Transaction Manager
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory d) throws IOException
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(d);
	   return hibernateTransactionManager;
		
	}
	*/
	//creating bean for hibernate Template
	@Bean
	@Scope("prototype")
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
