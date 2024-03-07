package com.tesco.offers.cardverifyservice.client.beans;

public class CardVerifyServiceResponse {
	
	private String respcode;
	private String respmsg;
	private boolean isValid;
	public String getRespcode() {
		return respcode;
	}
	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}
	public String getRespmsg() {
		return respmsg;
	}
	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardVerifyServiceResponse [respcode=");
		builder.append(respcode);
		builder.append(", respmsg=");
		builder.append(respmsg);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append("]");
		return builder.toString();
	}
	
	

}
