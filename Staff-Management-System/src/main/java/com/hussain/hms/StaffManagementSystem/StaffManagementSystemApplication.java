package com.hussain.hms.StaffManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class StaffManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementSystemApplication.class, args);
	}

}
