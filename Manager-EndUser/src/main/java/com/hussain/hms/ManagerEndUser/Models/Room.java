package com.hussain.hms.ManagerEndUser.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rooms")
public class Room {

	@Id
	private Long roomId;
	private int roomCharges;
	private String roomType;
	private String roomDesc;
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