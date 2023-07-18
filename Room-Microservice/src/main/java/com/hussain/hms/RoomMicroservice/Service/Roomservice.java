package com.hussain.hms.RoomMicroservice.Service;

import java.util.List;
import java.util.Optional;

import com.hussain.hms.RoomMicroservice.Models.Room;
import com.hussain.hms.RoomMicroservice.Models.RoomList;

public interface Roomservice {

	public Room addRoom(Room room);

	public Optional<Room> getRoom(long parseLong);

	public Room updateRoom(Room room);

	public String deleteRoom(long parseLong);

	public List<Room> getAllRoom();

	public RoomList getRoomAvl();

}
