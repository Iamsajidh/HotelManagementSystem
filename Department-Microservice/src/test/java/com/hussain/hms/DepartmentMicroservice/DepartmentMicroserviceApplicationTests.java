package com.hussain.hms.DepartmentMicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hussain.hms.DepartmentMicroservice.Model.Department;
import com.hussain.hms.DepartmentMicroservice.Repository.DepartmentRepository;
import com.hussain.hms.DepartmentMicroservice.Service.Departmentservice;
import com.hussain.hms.DepartmentMicroservice.Service.DepartmentserviceImpl;

@SpringBootTest
class DepartmentMicroserviceApplicationTests {

	@Mock
	private DepartmentRepository repo;

	@InjectMocks
	private DepartmentserviceImpl service;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllDepartmentsTest() {
		when(repo.findAll())
				.thenReturn(Stream
						.of(new Department(1L, "Cooking", "Cooking Description", 10),
								new Department(2L, "Cleaning", "Cleaning Description", 12))
						.collect(Collectors.toList()));

		List<Department> departments = service.getAlldept();

		assertEquals(2, departments.size());
		assertEquals("Cooking", departments.get(0).getDepartmentName());
		assertEquals("Cleaning", departments.get(1).getDepartmentName());
	}

	@Test
	public void addDepartmentTest() {
		Department department = new Department(1L, "Laundry", "Laundry Description", 5);

		when(repo.insert(department)).thenReturn(department);

		Department addedDepartment = service.addDepartment(department);

		assertEquals(department, addedDepartment);
	}

	@Test
	public void updateDepartmentTest() {
		Department department = new Department(1L, "Cooking", "Updated Cooking Description", 10);

		when(repo.save(department)).thenReturn(department);

		Department updatedDepartment = service.updateDepartment(department);

		assertEquals(department, updatedDepartment);
	}

	@Test
	public void getDepartmentByIdTest() {
		Department department = new Department(1L, "Cooking", "Cooking Description", 10);

		when(repo.findById(1L)).thenReturn(Optional.of(department));

		Optional<Department> retrievedDepartment = service.getDepartment(1L);

		assertEquals(department, retrievedDepartment.orElse(null));
	}
}
