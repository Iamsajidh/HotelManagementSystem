package com.hussain.hms.ReservationMicroservice.Services;

import java.util.List;
import java.util.Optional;

import com.hussain.hms.ReservationMicroservice.Models.Reservation;

public interface ReservationService {

	String addReservation(Reservation book);

	Reservation updateReservation(Reservation book);

	String deleteReservation(long parseLong);

	List<Reservation> getResList();

	Optional<Reservation> getReservation(long parseLong);
}