package com.hussain.hms.ReceptionistEndUser.Models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rooms")
public class Room {

	@Id
	private Long roomId;
	
	@Min(value = 0, message = "Room charges must be a positive value.")
	private int roomCharges;
	
	@NotEmpty(message = "Room type must not be empty.")
	private String roomType;
	
	private String roomDesc;
	
	@NotNull(message = "Room availability must be specified.")
	private boolean roomAvl;

	public Room() {
		super();
	}

	public Room(Long roomId, int roomCharges, String roomType, String roomDesc, boolean roomAvl) {
		super();
		this.roomId = roomId;
		this.roomCharges = roomCharges;
		this.roomType = roomType;
		this.roomDesc = roomDesc;
		this.roomAvl = roomAvl;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public int getRoomCharges() {
		return roomCharges;
	}

	public void setRoomCharges(int roomCharges) {
		this.roomCharges = roomCharges;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public boolean isRoomAvl() {
		return roomAvl;
	}

	public void setRoomAvl(boolean roomAvl) {
		this.roomAvl = roomAvl;
	}
}
