package com.hussain.hms.DepartmentMicroservice.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.DepartmentMicroservice.Model.Department;
import com.hussain.hms.DepartmentMicroservice.Model.DepartmentList;
import com.hussain.hms.DepartmentMicroservice.Service.Departmentservice;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	Departmentservice service;

	// Adding department details.
	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) {
		return this.service.addDepartment(dept);
	}

	// Fetching all the department details.
	@GetMapping("/findAll")
	public DepartmentList getDepartment() {
		DepartmentList list = new DepartmentList();
		list.setAlldept(this.service.getAlldept());
		return list;
	}

	// Fetching details by using departmentId.
	// In order to avoid NullPointerException we use Optional<>.
	@GetMapping("/findById/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") String id) {
		return this.service.getDepartment(Long.parseLong(id));
	}

	// Updating department details.
	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dept) {
		return this.service.updateDepartment(dept);
	}

	// Deleting department by using particular departmentId.
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String id) {
		return this.service.deleteDepartment(Long.parseLong(id));
	}
}
