package com.hussain.hms.StaffManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.hms.StaffManagementSystem.Exception.StaffNotFoundException;
import com.hussain.hms.StaffManagementSystem.Model.StaffDetails;
import com.hussain.hms.StaffManagementSystem.Repositories.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	StaffRepository staffRepository;

	public StaffDetails addStaffDetails(StaffDetails staffDetails)
	{
		validateStaffDetails(staffDetails);
		
//		staffDetails.setSalary(0);
//		staffDetails.setOccupation("Unspecified");
		
		return staffRepository.save(staffDetails);
	}
	
	public StaffDetails updateStaffDetails(StaffDetails staffDetails)
	{
		validateStaffDetails(staffDetails);
		
		StaffDetails existingStaffDetails = staffRepository.findById(staffDetails.getCode()).orElse(null);
		
		if(existingStaffDetails == null)
		{
			throw new StaffNotFoundException("Staff member doesnot exist with code: " + staffDetails.getCode());
		}
		
		existingStaffDetails.setEmpName(staffDetails.getEmpName());
		existingStaffDetails.setEmpAddress(staffDetails.getEmpAddress());
		existingStaffDetails.setNic(staffDetails.getNic());
		existingStaffDetails.setSalary(staffDetails.getSalary());
		existingStaffDetails.setAge(staffDetails.getAge());
		existingStaffDetails.setOccupation(staffDetails.getOccupation());
		existingStaffDetails.setEmail(staffDetails.getEmail());
		
		return staffRepository.save(existingStaffDetails);
		
	}
	
	
	public void deleteStaffDetails(String code)
	{
		StaffDetails existingStaffDetails = staffRepository.findById(code).orElse(null);
		
		if(existingStaffDetails == null)
		{
			throw new StaffNotFoundException("Staff member doesnot exist with code: " + code);
			
		}
		
		staffRepository.deleteById(code);
	}
	
	public StaffDetails getStaffByCode(String code)
	{
		StaffDetails staffDetails = staffRepository.findById(code).orElse(null);
		
		if(staffDetails == null)
		{
			throw new StaffNotFoundException("Staff member doesnot exist with code: " + code);
		}
		
		return staffDetails;
	}
	
	private void validateStaffDetails(StaffDetails staffDetails)
	{
		
	}
}
