/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Tesco
 * @Date:Mar 6, 2019
 * @Time:11:31:47 AM
 * @Description:Tesco Project
 */
@RestController
public class CustomerRestController {

	/**
	 * 
	 */
	public CustomerRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private Customer customer;
	
	@GetMapping("/customers")
	public Customer getCus()
	{
		Customer dd=new Customer();
		dd.setFirstname("swetha");
		dd.setId(1L);
		dd.setLastname("ammu");
		System.out.println("bean::::::"+customer);
		return dd;
		
		
	}
	
	
	@PostMapping(value="/cus")
	public Customer getCus1(@RequestBody Customer cus)
	{
		Customer dd=new Customer();
		dd.setFirstname("swetha");
		dd.setId(1L);
		dd.setLastname("ammu");
		
		return dd;
		
		
	}
	
	
	
	
	
	
	

}
