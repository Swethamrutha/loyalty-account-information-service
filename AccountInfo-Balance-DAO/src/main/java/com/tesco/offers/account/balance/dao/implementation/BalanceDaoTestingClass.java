/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.balance.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;

/**
 * @author:Tesco
 * @Date:Mar 8, 2019
 * @Time:7:56:47 AM
 * @Description:Tesco Project
 */

@RestController
@RequestMapping("/checkbalance")
public class BalanceDaoTestingClass {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private BalanceDAOImplementation balanceDAOImplementation;

	
	public BalanceDaoTestingClass() {
		// TODO Auto-generated constructor stub
	}

	
	@GetMapping("/custo")
	public String getCus() throws BalanceBusinessException, BalanceSystemException {
		System.out.println(hibernateTemplate);
		BalanceDaoRequest request = new BalanceDaoRequest();
		request.setClientid("web");
		request.setChannelid("online");
		request.setAccountnumber("1111222233334444");
		BalanceDAOResponse mm = balanceDAOImplementation.getBalance(request);
		return "hi";

	}
	
	
	
	
	
}
