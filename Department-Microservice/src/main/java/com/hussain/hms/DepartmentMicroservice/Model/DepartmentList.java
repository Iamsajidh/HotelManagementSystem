package com.hussain.hms.DepartmentMicroservice.Model;

import java.util.List;

public class DepartmentList {
	
	private List<Department> alldept;

	public List<Department> getAlldept() {
		return alldept;
	}

	public void setAlldept(List<Department> alldept) {
		this.alldept = alldept;
	}

}
