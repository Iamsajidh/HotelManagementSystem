package com.hussain.hms.ManagerEndUser.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Staff")
public class Staff {

	@Id
	private Long empId;
	private Long empDeptId;
	private String empName;
	private String empDeptName;
	private String email;
	private int empSalary;

	public Staff() {

	}

	public Staff(Long empId, Long empDeptId, String empName, String empDeptName, String email, int empSalary) {
		super();
		this.empId = empId;
		this.empDeptId = empDeptId;
		this.empName = empName;
		this.empDeptName = empDeptName;
		this.email = email;
		this.empSalary = empSalary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getEmpDeptId() {
		return empDeptId;
	}

	public void setEmpDeptId(Long empDeptId) {
		this.empDeptId = empDeptId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDeptName() {
		return empDeptName;
	}

	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Staff [empId=" + empId + ", empDeptId=" + empDeptId + ", empName=" + empName + ", empDeptName="
				+ empDeptName + ", email=" + email + ", empSalary=" + empSalary + "]";
	}

}
