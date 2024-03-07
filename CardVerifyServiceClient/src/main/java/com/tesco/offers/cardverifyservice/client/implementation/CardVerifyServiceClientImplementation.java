package com.tesco.offers.cardverifyservice.client.implementation;

import org.springframework.stereotype.Component;

import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceRequest;
import com.tesco.offers.cardverifyservice.client.beans.CardVerifyServiceResponse;
import com.tesco.offers.cardverifyservice.client.interf.CardVerifyServiceClient;


@Component
public class CardVerifyServiceClientImplementation implements CardVerifyServiceClient{

	public CardVerifyServiceResponse verifyCard(CardVerifyServiceRequest request) {
		// TODO Auto-generated method stub
		
		CardVerifyServiceResponse response=new CardVerifyServiceResponse();
		response.setRespcode("0000");
		response.setRespmsg("sucess");
		response.setValid(true);
		
		return response;
	}

}
