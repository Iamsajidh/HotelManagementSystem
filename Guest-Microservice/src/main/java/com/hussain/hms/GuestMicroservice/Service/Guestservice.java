package com.hussain.hms.GuestMicroservice.Service;

import java.util.List;
import java.util.Optional;

import com.hussain.hms.GuestMicroservice.Models.Guest;

public interface Guestservice {

	Guest addGuest(Guest guest);

	Guest updateGuest(Guest guest);

	String deleteGuest(int id);

	Optional<Guest> getGuest(int id);

	List<Guest> getAllGuest();

}