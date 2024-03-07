package com.tesco.offers.cardverifyservice.client.interf;

import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceRequest;
import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceResponse;

public interface CardVerifyServiceClient {

	public CardVerifyServiceResponse verifyCard(CardVerifyServiceRequest request);
	

	
	
	
	
}
