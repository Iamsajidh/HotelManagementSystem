package com.hussain.hms.StaffManagementSystem.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.StaffManagementSystem.Model.StaffDetails;

@Repository
public interface StaffRepository extends MongoRepository<StaffDetails, String> {

}
