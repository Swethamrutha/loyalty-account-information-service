/**
 * 
 */
package com.tesco.offers.account.linkedcard.dao.interf;

import java.sql.SQLException;

import com.tesco.offers.account.linkedcard.dao.beans.CardsDAORequest;
import com.tesco.offers.account.linkedcard.dao.beans.CardsDAOResponse;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardBusinessException;
import com.tesco.offers.account.linkedcard.dao.exception.LinkedCardSystemException;

/**
 * @author stech3
 *
 */
public interface CardsDAO {
	
	public CardsDAOResponse getAllCards(CardsDAORequest request) throws LinkedCardBusinessException, LinkedCardSystemException, ClassNotFoundException, SQLException;
	
	

}
