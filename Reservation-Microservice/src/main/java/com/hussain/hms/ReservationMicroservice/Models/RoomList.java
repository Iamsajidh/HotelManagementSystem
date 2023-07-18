package com.hussain.hms.ReservationMicroservice.Models;

import java.util.List;

public class RoomList {

	private List<Room> allRoom;

	public List<Room> getAllRoom() {
		return allRoom;
	}

	public void setAllRoom(List<Room> allRoom) {
		this.allRoom = allRoom;
	}

}
