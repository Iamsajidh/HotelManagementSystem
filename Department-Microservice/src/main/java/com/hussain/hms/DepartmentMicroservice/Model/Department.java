package com.hussain.hms.DepartmentMicroservice.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//It is used to identify a domain object, which is persisted to MongoDB.
@Document(collection = "Department Details")
public class Department {

	// It allows to specify exactly one id.(primary key).
	@Id
	private long departmentID;
	private String departmentName;
	private String desc;
	
	private int noOfEmployee;

	public Department() {
		super();
	}

	public Department(long departmentID, String departmentName, String desc, int no_of_Emp) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.desc = desc;
		this.noOfEmployee = no_of_Emp;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getNo_of_Emp() {
		return noOfEmployee;
	}

	public void setNo_of_Emp(int no_of_Emp) {
		this.noOfEmployee = no_of_Emp;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", desc=" + desc
				+ ", no_of_Emp=" + noOfEmployee + "]";
	}

}
