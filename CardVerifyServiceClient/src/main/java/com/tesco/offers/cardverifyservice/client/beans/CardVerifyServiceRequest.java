package com.tesco.offers.cardverifyservice.client.beans;

public class CardVerifyServiceRequest {
	private String cardnumber;
	private String clientid;
	private String channelid;
	private String correlationid;
	private String messageTimeStamp;
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getCorrelationid() {
		return correlationid;
	}
	public void setCorrelationid(String correlationid) {
		this.correlationid = correlationid;
	}
	public String getMessageTimeStamp() {
		return messageTimeStamp;
	}
	public void setMessageTimeStamp(String messageTimeStamp) {
		this.messageTimeStamp = messageTimeStamp;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardVerifyServiceRequest [cardnumber=");
		builder.append(cardnumber);
		builder.append(", clientid=");
		builder.append(clientid);
		builder.append(", channelid=");
		builder.append(channelid);
		builder.append(", correlationid=");
		builder.append(correlationid);
		builder.append(", messageTimeStamp=");
		builder.append(messageTimeStamp);
		builder.append("]");
		return builder.toString();
	}
	

}
