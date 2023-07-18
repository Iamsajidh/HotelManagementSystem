package com.hussain.hms.RoomMicroservice.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.RoomMicroservice.Models.Room;
import com.hussain.hms.RoomMicroservice.Models.RoomList;
import com.hussain.hms.RoomMicroservice.Service.Roomservice;
import com.hussain.hms.RoomMicroservice.Exception.RoomNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private Roomservice roomService;

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping("/findAllRoom")
    public RoomList getAllRoom() {
        RoomList list = new RoomList();
        list.setAllRoom(roomService.getAllRoom());
        return list;
    }

    @GetMapping("/findById/{id}")
    public Optional<Room> getRoom(@PathVariable("id") String id) {
        return roomService.getRoom(Long.parseLong(id));
    }

    @PutMapping("/updateRoom")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") String id) {
        try {
            return roomService.deleteRoom(Long.parseLong(id));
        } catch (RoomNotFoundException ex) {
            throw new RoomNotFoundException("Room not found with ID: " + id);
        }
    }

    @GetMapping("/findRoomAvl")
    public RoomList getRoomAvl() {
        return roomService.getRoomAvl();
    }
}
