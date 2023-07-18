package com.hussain.hms.RoomMicroservice.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hussain.hms.RoomMicroservice.Models.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, Long> {

	@Query("{roomAvl:true}")
	List<Room> findAvailable();

}
