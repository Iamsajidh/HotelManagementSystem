package com.hussain.hms.StaffManagementSystem.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff")
public class StaffDetails {
	
	@Id
	private String code;
	private String empName;
	private String empAddress;
	private String nic;
	private double salary;
	private int age;
	private String occupation;
	private String email;
	public StaffDetails(String code, String empName, String empAddress, String nic, double salary, int age,
			String occupation, String email) {
		super();
		this.code = code;
		this.empName = empName;
		this.empAddress = empAddress;
		this.nic = nic;
		this.salary = salary;
		this.age = age;
		this.occupation = occupation;
		this.email = email;
	}
	public StaffDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "StaffDetails [Code=" + code + ", Employee Name=" + empName + ", Emp Address=" + empAddress + ", NIC=" + nic
				+ ", Salary=" + salary + ", Age=" + age + ", Occupation=" + occupation + ", E-mail=" + email + "]";
	}
	
	
}
