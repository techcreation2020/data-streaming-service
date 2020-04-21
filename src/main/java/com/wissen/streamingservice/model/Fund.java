package com.wissen.streamingservice.model;

import java.io.Serializable;
import java.util.Date;

public class Fund implements Serializable {

	private static final long serialVersionUID = -3795697243966752074L;

	private Long id;

	private Integer units;

	private String fundName;

	private Date updatedOn;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}