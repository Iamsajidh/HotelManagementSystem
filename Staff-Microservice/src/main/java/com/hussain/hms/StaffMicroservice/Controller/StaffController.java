package com.hussain.hms.StaffMicroservice.Controller;

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

import com.hussain.hms.StaffMicroservice.Model.Staff;
import com.hussain.hms.StaffMicroservice.Model.StaffList;
import com.hussain.hms.StaffMicroservice.Service.Staffservice;
import com.hussain.hms.StaffMicroservice.Exception.StaffNotFoundException;

@RestController
@RequestMapping("/Staff")
public class StaffController {

    @Autowired
    private Staffservice staffService;

    @PostMapping("/addEmp")
    public Staff addEmployee(@RequestBody Staff emp) {
        return staffService.addEmp(emp);
    }

    @GetMapping("/getAllEmp")
    public StaffList getAllEmployee() {
        StaffList list = new StaffList();
        list.setAllEmp(staffService.getAllEmp());
        return list;
    }

    @GetMapping("/getByEmp/{id}")
    public Optional<Staff> getEmployee(@PathVariable("id") String id) {
        return staffService.getEmp(Long.parseLong(id));
    }

    @PutMapping("/updateEmp")
    public Staff updateEmployee(@RequestBody Staff emp) {
        return staffService.updateEmp(emp);
    }

    @DeleteMapping("/deleteByEmp/{id}")
    public String deleteEmployee(@PathVariable("id") String id) {
        try {
            return staffService.deleteEmp(Long.parseLong(id));
        } catch (StaffNotFoundException ex) {
            throw new StaffNotFoundException("Employee not found with ID: " + id);
        }
    }
}
