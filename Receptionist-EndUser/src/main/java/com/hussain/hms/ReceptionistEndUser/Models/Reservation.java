package com.hussain.hms.ReceptionistEndUser.Models;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReservationDetails")
public class Reservation {

	@Id
	private Long bookingId;
	
	@NotNull(message = "Room ID must not be null.")
	private Long roomId;
	
	@NotEmpty(message = "Check-in date must not be empty.")
	@Future(message = "Check-in date must be a future date.")
	private String checkin;
	
	@NotEmpty(message = "Check-out date must not be empty.")
	@Future(message = "Check-out date must be a future date.")
	private String checkout;
	
	@Min(value = 1, message = "Number of guests must be at least 1.")
	private int numOfGuests;
	
	@Positive(message = "Final price must be a positive value.")
	private double finalPrice;
	
	public Reservation(Long bookingId, Long roomId, String checkin, String checkout, int numOfGuests,
			double finalPrice) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.checkin = checkin;
		this.checkout = checkout;
		this.numOfGuests = numOfGuests;
		this.finalPrice = finalPrice;
	}

	public Reservation() {
		super();
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public int getNumOfGuests() {
		return numOfGuests;
	}

	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

}
