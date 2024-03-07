/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author:Tesco
 * @Date:Feb 15, 2019
 * @Time:5:19:50 PM
 * @Description:Tesco Project
 */
@Configuration

public class RepositoryConfig {
	
	@Value("${driverClassName}")
	private String driverClassName;
	
	@Value("${url}")
	private String url;

	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.format_sql}")
	private String format_sql;
	
	@Value("${hibernate.show_sql}")
	private String show_sql;
	
	
	
	
	@Bean
	
	public DataSource dataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(driverClassName);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		return datasource;
		
	}

	
	
	//creating bean for hibernate Template
		@Bean
		public HibernateTemplate hibernateTemplatefeature(SessionFactory d) throws IOException
		{
			HibernateTemplate hibernateTemplate=new HibernateTemplate();
			hibernateTemplate.setSessionFactory(d);
			return hibernateTemplate;
			
		}
		
		@Bean
		
		public SessionFactory  sessionFactory(DataSource d) throws IOException
		{
			LocalSessionFactoryBean sessionfactory=new LocalSessionFactoryBean();
			sessionfactory.setPackagesToScan("com.tesco.offers.account.features.dao.entities");
			sessionfactory.setDataSource(d);
			sessionfactory.setHibernateProperties(hibernateProperties());
			sessionfactory.afterPropertiesSet();
			return sessionfactory.getObject();
			
		}



		@Bean
		
		public Properties hibernateProperties() {
			Properties properties=new Properties();
			properties.put("hibernate.dialect", dialect);
			properties.put("hibernate.format_sql", format_sql);
			properties.put("hibernate.show_sql", show_sql);
			return properties;
		}
	
	
	
	

}
