/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author:Tesco
 * @Date:Feb 4, 2019
 * @Time:7:34:05 PM
 * @Description:Tesco Project
 */

public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private HibernateUtils() {

	}

	private static synchronized SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub

		if (sessionFactory == null) {
			
			
			Configuration configure=new Configuration().configure();
			 sessionFactory=configure.buildSessionFactory();
			System.out.println("SessionFactory:::"+sessionFactory);
			
			
		/*	Configuration cfg=new Configuration().configure(HibernateUtils.class.getResource("/hibernate.cfg.xml"));
			
			StandardServiceRegistryBuilder service=new StandardServiceRegistryBuilder();
			service.applySettings(cfg.getProperties()).build();
			ServiceRegistryBuilder ser=new ServiceRegistryBuilder();
			ServiceRegistry serReg=ser.applySettings(cfg).buildServiceRegistry();
			
			sessionFactory=cfg.buildSessionFactory();
		*/	
			
			
	/*Configuration cfg = new Configuration().configure();

			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();

			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
*/
			
		
		}
		return sessionFactory;

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
