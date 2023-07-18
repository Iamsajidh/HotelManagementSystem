package com.hussain.hms.StaffMicroservice.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Staff")
public class Staff {

    @Id
    private Long empId;

    @NotNull(message = "Employee department ID is required")
    private Long empDeptId;

    @NotBlank(message = "Employee name is required")
    private String empName;

    @NotBlank(message = "Employee department name is required")
    private String empDeptName;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String email;

    @Positive(message = "Employee salary must be a positive number")
    private int empSalary;

    public Staff() {

    }

    public Staff(Long empId, Long empDeptId, String empName, String empDeptName, String email, int empSalary) {
        this.empId = empId;
        this.empDeptId = empDeptId;
        this.empName = empName;
        this.empDeptName = empDeptName;
        this.email = email;
        this.empSalary = empSalary;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(Long empDeptId) {
        this.empDeptId = empDeptId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDeptName() {
        return empDeptName;
    }

    public void setEmpDeptName(String empDeptName) {
        this.empDeptName = empDeptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Staff [empId=" + empId + ", empDeptId=" + empDeptId + ", empName=" + empName + ", empDeptName="
                + empDeptName + ", email=" + email + ", empSalary=" + empSalary + "]";
    }
}
