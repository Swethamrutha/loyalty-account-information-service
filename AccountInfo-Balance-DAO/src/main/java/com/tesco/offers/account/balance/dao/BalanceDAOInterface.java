/* @CopyRights  Tesco. All rights are reserved. */
package com.tesco.offers.account.balance.dao;

import java.sql.SQLException;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;

/**
 * @author:Tesco
 * @Date:Jan 7, 2019
 * @Time:7:49:36 PM 
 * @Description:Tesco Developing Project
 */
public interface BalanceDAOInterface {
	
	public BalanceDAOResponse getBalance(BalanceDaoRequest request) throws BalanceBusinessException, BalanceSystemException, ClassNotFoundException, SQLException;

}
