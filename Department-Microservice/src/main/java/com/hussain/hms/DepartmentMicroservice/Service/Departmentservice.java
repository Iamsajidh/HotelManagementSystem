package com.hussain.hms.DepartmentMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hussain.hms.DepartmentMicroservice.Model.Department;

@Service
public interface Departmentservice {

	Department addDepartment(Department dept);

	List<Department> getAlldept();

	Optional<Department> getDepartment(long parseLong);

	Department updateDepartment(Department dept);

	String deleteDepartment(long parseLong);


}