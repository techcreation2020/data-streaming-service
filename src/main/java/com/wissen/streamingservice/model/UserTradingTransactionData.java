package com.wissen.streamingservice.model;

public class UserTradingTransactionData {
	
	private Integer transaction_id;
    private String user;
    private String securities;
    private Integer currentPosition;
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSecurities() {
		return securities;
	}
	public void setSecurities(String securities) {
		this.securities = securities;
	}
	public Integer getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Integer currentPosition) {
		this.currentPosition = currentPosition;
	}
	@Override
	public String toString() {
		return "UserTradingTransactionData [transaction_id=" + transaction_id + ", user=" + user + ", securities="
				+ securities + ", currentPosition=" + currentPosition + "]";
	} 

}
