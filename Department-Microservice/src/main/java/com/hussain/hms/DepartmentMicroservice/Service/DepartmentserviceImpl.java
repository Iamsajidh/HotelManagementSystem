package com.hussain.hms.DepartmentMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.hms.DepartmentMicroservice.Model.Department;
import com.hussain.hms.DepartmentMicroservice.Repository.DepartmentRepository;

@Service
public class DepartmentserviceImpl implements Departmentservice {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentserviceImpl.class);

	@Autowired
	private DepartmentRepository repo;

	@Override
	public Department addDepartment(Department dept) {
		logger.info("Adding a department: {}", dept);
		return repo.insert(dept);
	}

	@Override
	public String deleteDepartment(long id) {
		logger.info("Deleting department with ID: {}", id);
		repo.deleteById(id);
		return "Department Deleted";
	}

	@Override
	public Department updateDepartment(Department dept) {
		logger.info("Updating department: {}", dept);
		return repo.save(dept);
	}

	@Override
	public Optional<Department> getDepartment(long id) {
		logger.info("Getting department with ID: {}", id);
		return repo.findById(id);
	}

	@Override
	public List<Department> getAlldept() {
		logger.info("Getting all departments");
		return repo.findAll();
	}
}
