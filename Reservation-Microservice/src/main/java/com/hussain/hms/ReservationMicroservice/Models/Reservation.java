package com.hussain.hms.ReservationMicroservice.Models;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ReservationDetails")
public class Reservation {

    @Id
    private Long bookingId;

    @NotNull(message = "Room ID is required")
    private Long roomId;

    @NotBlank(message = "Check-in date is required")
    private String checkin;

    @NotBlank(message = "Check-out date is required")
    private String checkout;

    @Min(value = 1, message = "Number of guests must be at least 1")
    private int numOfGuests;

    private double finalPrice;

    public Reservation(Long bookingId, Long roomId, String checkin, String checkout, int numOfGuests,
            double finalPrice) {
        this.bookingId = bookingId;
        this.roomId = roomId;
        this.checkin = checkin;
        this.checkout = checkout;
        this.numOfGuests = numOfGuests;
        this.finalPrice = finalPrice;
    }

    public Reservation() {
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
