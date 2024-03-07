package com.tesco.offers.account.process.implementation;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.offers.account.balance.dao.exception.BalanceBusinessException;
import com.tesco.offers.account.balance.dao.exception.BalanceSystemException;
import com.tesco.offers.account.balance.dao.implementation.BalanceDAOImplementation;
import com.tesco.offers.account.balances.dao.beans.BalanceDAOResponse;
import com.tesco.offers.account.balances.dao.beans.BalanceDaoRequest;
import com.tesco.offers.account.process.beans.TaskResult;

@Component
public class BalanceTask implements Callable<TaskResult> {

	@Autowired
	private BalanceDAOImplementation balanceDAOImplementation;

	private BalanceDaoRequest daoRequest1;

	public void setDaoRequest1(BalanceDaoRequest daoRequest1) {
		this.daoRequest1 = daoRequest1;
	}

	public BalanceDaoRequest getDaoRequest1() {
		return daoRequest1;
	}

	public TaskResult call()
			throws BalanceBusinessException, BalanceSystemException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		System.out.println(daoRequest1);
		System.out.println("Injecting balance dao::::::::::" + balanceDAOImplementation);

		System.out.println("Entered into Balance Task");
		// System.out.println(balanceDAOImplementation);
		TaskResult result = new TaskResult();
		// BalanceDAOImplementation balanceDAOImplementation = new
		// BalanceDAOImplementation();

		// BalanceDAOResponse daoResp =
		// balanceDAOImplementation.getBalance(daoRequest1);
		BalanceDAOResponse daoResp = balanceDAOImplementation.getBalance(daoRequest1);
		System.out.println(daoResp);

		result.setTaskName("balanceTask");
		result.setResult(daoResp);

		System.out.println(result);
		System.out.println("Exit from Balance task");
		return result;
	}

	/*
	 * public TaskResult call(BalanceDaoRequest balancedaoRequest) throws
	 * Exception { // TODO Auto-generated method stub return null; }
	 * 
	 */

	public static void main(String[] args)
			throws ClassNotFoundException, BalanceBusinessException, BalanceSystemException, SQLException {
		BalanceDaoRequest request = new BalanceDaoRequest();
		request.setClientid("web");
		request.setChannelid("online");
		request.setAccountnumber("1111222233334444");

		// BalanceTask b = new BalanceTask(request);

		ExecutorService svc = Executors.newFixedThreadPool(3);

		Set tasks = new HashSet();

		// tasks.add(new BalanceTask(request));

		try {
			svc.invokeAll(tasks);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ApplicationContext factory = new
		 * AnnotationConfigApplicationContext(ConfigurationFile_Balance.class);
		 * System.out.println(factory); String[] nn =
		 * factory.getBeanDefinitionNames(); for (String name : nn) {
		 * System.out.println(name); }
		 * 
		 * BalanceDaoRequest request = new BalanceDaoRequest();
		 * request.setClientid("web"); request.setChannelid("online");
		 * request.setAccountnumber("1111222233334444");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * BalanceDAOImplementation bb =
		 * factory.getBean(BalanceDAOImplementation.class);
		 * bb.getBalance(request);
		 */

		/*
		 * BalanceTask ff = factory.getBean(BalanceTask.class); ff.call();
		 */

	}

}
