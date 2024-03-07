package com.tesco.offers.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author:Tesco
 * @Date:Mar 4, 2019
 * @Time:3:45:46 PM
 * @Description:Tesco Project
 */

public class AppIntializerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 
	 */
	
	
	public AppIntializerInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{/*AllConfiguration.class*/};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{AllConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

}
