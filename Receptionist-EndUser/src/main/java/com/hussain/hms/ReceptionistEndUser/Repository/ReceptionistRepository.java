package com.hussain.hms.ReceptionistEndUser.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.ReceptionistEndUser.Models.ReceptionistInformation;

@Repository
public interface ReceptionistRepository extends MongoRepository<ReceptionistInformation, String> {

	ReceptionistInformation findByEmail(String email);

}
