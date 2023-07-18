package com.hussain.hms.StaffMicroservice.Service;

import java.util.List;
import java.util.Optional;

import com.hussain.hms.StaffMicroservice.Model.Staff;

public interface Staffservice {

	Staff addEmp(Staff emp);

	List<Staff> getAllEmp();

	Optional<Staff> getEmp(long parseLong);

	Staff updateEmp(Staff emp);

	String deleteEmp(long parseLong);

}
