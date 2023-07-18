package com.hussain.hms.ReservationMicroservice.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.ReservationMicroservice.Models.Reservation;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, Long> {

}