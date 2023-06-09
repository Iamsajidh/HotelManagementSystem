package com.hussain.hms.GuestManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GuestManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestManagementSystemApplication.class, args);
	}

}
