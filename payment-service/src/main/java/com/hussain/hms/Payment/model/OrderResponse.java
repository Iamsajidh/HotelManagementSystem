package com.hussain.hms.Payment.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class OrderResponse {
	String secretKey;
	String razorpayOrderId;
	String applicationFee;
	String secretId;
	String pgName;
	
	
	
	public OrderResponse(String secretKey, String razorpayOrderId, String applicationFee, String secretId,
			String pgName) {
		super();
		this.secretKey = secretKey;
		this.razorpayOrderId = razorpayOrderId;
		this.applicationFee = applicationFee;
		this.secretId = secretId;
		this.pgName = pgName;
	}
	
	
	
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	public String getApplicationFee() {
		return applicationFee;
	}
	public void setApplicationFee(String applicationFee) {
		this.applicationFee = applicationFee;
	}
	public String getSecretId() {
		return secretId;
	}
	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	public String getPgName() {
		return pgName;
	}
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}



	@Override
	public String toString() {
		return "OrderResponse [secretKey=" + secretKey + ", razorpayOrderId=" + razorpayOrderId + ", applicationFee="
				+ applicationFee + ", secretId=" + secretId + ", pgName=" + pgName + "]";
	}
	
	
	
	
	
}
