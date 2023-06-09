package com.hussain.hms.GuestManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.GuestManagementSystem.model.GuestDetails;

@Repository
public interface GuestRepository extends MongoRepository<GuestDetails, String> {
 
}



