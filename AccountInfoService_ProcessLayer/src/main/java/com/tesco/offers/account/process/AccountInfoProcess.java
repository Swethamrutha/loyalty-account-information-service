package com.tesco.offers.account.process;

import com.tesco.offers.account.process.beans.AccountInfoProcessRequestBean;
import com.tesco.offers.account.process.beans.AccountInfoProcessResponseBean;

public interface AccountInfoProcess {
	
	public AccountInfoProcessResponseBean getAccount(AccountInfoProcessRequestBean processrequest) throws Exception;
	

}
