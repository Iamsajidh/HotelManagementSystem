package com.hussain.hms.GuestMicroservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.GuestMicroservice.Models.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, Integer> {

}