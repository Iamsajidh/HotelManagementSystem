package com.hussain.hms.RoomMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hussain.hms.RoomMicroservice.Models.Room;
import com.hussain.hms.RoomMicroservice.Models.RoomList;
import com.hussain.hms.RoomMicroservice.Repository.RoomRepository;
import com.hussain.hms.RoomMicroservice.Exception.RoomNotFoundException;

@Service
public class RoomserviceImpl implements Roomservice {

	
	//Logger
    private static final Logger logger = LoggerFactory.getLogger(RoomserviceImpl.class);

    @Autowired
    RoomRepository roomRepository;

    @Override
    public Room addRoom(Room room) {
        logger.info("Adding room: {}", room);
        return roomRepository.insert(room);
    }

    @Override
    public Optional<Room> getRoom(long id) {
        logger.info("Retrieving room with ID: {}", id);
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new RoomNotFoundException("Room not found with ID: " + id);
        }
        return room;
    }

    @Override
    public Room updateRoom(Room room) {
        logger.info("Updating room: {}", room);
        return roomRepository.save(room);
    }

    @Override
    public String deleteRoom(long id) {
        logger.info("Deleting room with ID: {}", id);
        if (!roomRepository.existsById(id)) {
            throw new RoomNotFoundException("Room not found with ID: " + id);
        }
        roomRepository.deleteById(id);
        return "Room Number " + id + " Deleted";
    }

    @Override
    public List<Room> getAllRoom() {
        logger.info("Retrieving all rooms");
        return roomRepository.findAll();
    }

    @Override
    public RoomList getRoomAvl() {
        logger.info("Retrieving available rooms");
        RoomList list = new RoomList();
        list.setAllRoom(roomRepository.findAvailable());
        return list;
    }
}
