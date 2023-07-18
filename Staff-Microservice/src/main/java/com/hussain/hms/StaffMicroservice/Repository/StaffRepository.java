package com.hussain.hms.StaffMicroservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.StaffMicroservice.Model.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff, Long> {

}
