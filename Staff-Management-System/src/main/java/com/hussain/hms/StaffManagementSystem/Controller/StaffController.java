package com.hussain.hms.StaffManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.StaffManagementSystem.Model.StaffDetails;
import com.hussain.hms.StaffManagementSystem.Service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@PostMapping
	public ResponseEntity<StaffDetails> addStaffDetails(@RequestBody StaffDetails staffDetails)
	{
		StaffDetails addedStaffDetails = staffService.addStaffDetails(staffDetails);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addedStaffDetails);
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<StaffDetails> deleteStaffDetails(@PathVariable String code)
	{
		staffService.deleteStaffDetails(code);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<StaffDetails> getStaffDetails(@PathVariable String code)
	{
		StaffDetails staffDetails = staffService.getStaffByCode(code);
		return ResponseEntity.ok(staffDetails);
	}

}
