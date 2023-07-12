package com.hussain.hms.ManagerEndUser.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "ManagerInformation")
public class ManagerInformation {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	
	public ManagerInformation(String id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public ManagerInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ManagerInformation [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	


}
