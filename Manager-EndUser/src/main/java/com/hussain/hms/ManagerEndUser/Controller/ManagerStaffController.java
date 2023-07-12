package com.hussain.hms.ManagerEndUser.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hussain.hms.ManagerEndUser.Models.Staff;
import com.hussain.hms.ManagerEndUser.Models.StaffList;

@RestController
@RequestMapping("/Manager/Staff")
public class ManagerStaffController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getAllEmp")
	public StaffList getAllEmp() {
		return restTemplate.getForObject("http://localhost:8081/Staff/getAllEmp/", StaffList.class);
	}

	@GetMapping("/getByEmp/{id}")
	public Staff getEmp(@PathVariable("id") String id) {
		return restTemplate.getForObject("http://localhost:8081/Staff/getByEmp/" + id, Staff.class);
	}

	@PostMapping("/addEmp")
	public Staff addStaff(@RequestBody Staff staff) {
		return restTemplate.postForObject("http://localhost:8081/Staff/addEmp/", staff, Staff.class);
	}

	@PutMapping("/updateEmp")
	public Staff updateStaff(@RequestBody Staff staff) {
		restTemplate.put("http://localhost:8081/Staff/updateEmp/", staff, Staff.class);
		return staff;
	}

	@DeleteMapping("/deleteByEmp/{id}")
	public String deleteStaff(@PathVariable("id") String id) {
		restTemplate.delete("http://localhost:8081/Staff/deleteByEmp/" + id);
		return "Deleted room " + id;
	}

}