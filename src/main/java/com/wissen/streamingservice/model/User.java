package com.wissen.streamingservice.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = -2777371715219203710L;
	
	private Long id;
	private String userName;
	private Fund fund;
	private Integer balance;
	private Date updaetdOn;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Date getUpdaetdOn() {
		return updaetdOn;
	}

	public void setUpdaetdOn(Date updaetdOn) {
		this.updaetdOn = updaetdOn;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fund=" + fund + ", balance=" + balance + ", updaetdOn="
				+ updaetdOn + "]";
	}
	
}
