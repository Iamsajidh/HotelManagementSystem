package com.hussain.hms.ManagerEndUser.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hussain.hms.ManagerEndUser.Models.ManagerInformation;

@Repository
public interface ManagerRepository extends MongoRepository<ManagerInformation, String> {

	ManagerInformation findByEmail(String email);

}
