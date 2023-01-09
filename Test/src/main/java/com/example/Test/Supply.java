package com.example.Test;

import java.util.Date;

public class Supply {

	private String productId;
	private java.util.Date updateTimeStamp; 
	private Double quantity;
	private String status;
	
	
	public Supply(String productId, Date updateTimeStamp, Double quantity, String status) {
		super();
		this.productId = productId;
		this.updateTimeStamp = updateTimeStamp;
		this.quantity = quantity;
		this.status = status;
	}
	public Supply(String productId, Date updateTimeStamp, Double quantity) {
		super();
		this.productId = productId;
		this.updateTimeStamp = updateTimeStamp;
		this.quantity = quantity;
		this.status = status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public java.util.Date getUpdateTimeStamp() {
		return updateTimeStamp;
	}
	public void setUpdateTimeStamp(java.util.Date updateTimeStamp) {
		this.updateTimeStamp = updateTimeStamp;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
