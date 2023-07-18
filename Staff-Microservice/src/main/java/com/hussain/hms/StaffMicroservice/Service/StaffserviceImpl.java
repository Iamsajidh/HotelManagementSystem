package com.hussain.hms.StaffMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hussain.hms.StaffMicroservice.Model.Staff;
import com.hussain.hms.StaffMicroservice.Repository.StaffRepository;
import com.hussain.hms.StaffMicroservice.Exception.StaffNotFoundException;

@Service
public class StaffserviceImpl implements Staffservice {

    private static final Logger logger = LoggerFactory.getLogger(StaffserviceImpl.class);

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff addEmp(Staff emp) {
        logger.info("Adding employee: {}", emp);
        return staffRepository.insert(emp);
    }

    @Override
    public List<Staff> getAllEmp() {
        logger.info("Retrieving all employees");
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getEmp(long id) {
        logger.info("Retrieving employee with ID: {}", id);
        Optional<Staff> staff = staffRepository.findById(id);
        if (staff.isEmpty()) {
            throw new StaffNotFoundException("Employee not found with ID: " + id);
        }
        return staff;
    }

    @Override
    public Staff updateEmp(Staff emp) {
        logger.info("Updating employee: {}", emp);
        return staffRepository.save(emp);
    }

    @Override
    public String deleteEmp(long id) {
        logger.info("Deleting employee with ID: {}", id);
        if (!staffRepository.existsById(id)) {
            throw new StaffNotFoundException("Employee not found with ID: " + id);
        }
        staffRepository.deleteById(id);
        return "Deleted employee with ID: " + id;
    }
}
