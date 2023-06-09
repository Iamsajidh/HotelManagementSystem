package com.hussain.hms.GuestManagementSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guests")
public class GuestDetails {
	
	@Id
	private String id;
	private String memberCode;
	private long phoneNumber;
	private String company;
	private String name;
	private String email;
	private String gender;
	private String address;
	
	
	public GuestDetails(String id, String memberCode, long phoneNumber, String company, String name, String email,
			String gender, String address) {
		super();
		this.id = id;
		this.memberCode = memberCode;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.address = address;
	}


	public GuestDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMemberCode() {
		return memberCode;
	}


	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "GuestDetails [id=" + id + ", memberCode=" + memberCode + ", phoneNumber=" + phoneNumber + ", company="
				+ company + ", name=" + name + ", email=" + email + ", gender=" + gender + ", address=" + address + "]";
	}
	
	
	
}
