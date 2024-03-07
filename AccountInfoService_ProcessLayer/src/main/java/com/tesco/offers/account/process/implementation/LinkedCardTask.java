/* @CopyRight Tesco.All Rights are reserved */
package com.tesco.offers.account.process.implementation;

import java.sql.SQLException;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAOResponse;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardBusinessException;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardSystemException;
import com.tesco.offers.account.linkedcard.dao.implentation.CardsDAOImplementation;
import com.tesco.offers.account.linkedcard.dao.interf.CardsDAO;
import com.tesco.offers.account.process.beans.TaskResult;

/**
 * @author:Tesco
 * @Date:Jan 8, 2019
 * @Time:9:23:56 AM
 * @Description:Tesco Project
 */
@Component
public class LinkedCardTask implements Callable<TaskResult> {
	
	@Autowired
	private CardsDAOImplementation cardsDAOImplementation;
	
	private CardsDAORequest linkedCardRequest;

	public void setLinkedCardRequest(CardsDAORequest linkedCardRequest) {
		this.linkedCardRequest = linkedCardRequest;
	}
	
	/*LinkedCardTask(CardsDAORequest linkedCardRequest)
	{
		this.linkedCardRequest=linkedCardRequest;
	}*/





	public TaskResult call() throws LinkedCardBusinessException,LinkedCardSystemException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		TaskResult result=new TaskResult();
		System.out.println("Entered into LinkedCard Task" );
		System.out.println("bean injection in cards:::::"+cardsDAOImplementation);
		//CardsDAO cardDao=new CardsDAOImplementation();
		CardsDAOResponse cardDaoResponse=cardsDAOImplementation.getAllCards(linkedCardRequest);
		System.out.println("Linkedcards Task Data:::::"+cardDaoResponse);
		System.out.println("Linkedcards Task Data:::::"+cardDaoResponse);
		//TaskResult result=new TaskResult();
		result.setTaskName("linkedCardTask");
		result.setResult(cardDaoResponse);
		
		System.out.println("Linked Data in LinkedCardTask:::"+result);
		
		System.out.println("Exit from LinkedCard Task");
         return result;
	}

}
