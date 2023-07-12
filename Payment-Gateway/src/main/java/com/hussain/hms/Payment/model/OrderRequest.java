package com.hussain.hms.Payment.model;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OrderRequest {
	
	String customerName;
	String email;
	String phoneNumber;
	BigInteger amount;
	
	
	public OrderRequest(String customerName, String email, String phoneNumber, BigInteger amount) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
	}


	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public BigInteger getAmount() {
		return amount;
	}


	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "OrderRequest [customerName=" + customerName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", amount=" + amount + "]";
	}
	
	
}
