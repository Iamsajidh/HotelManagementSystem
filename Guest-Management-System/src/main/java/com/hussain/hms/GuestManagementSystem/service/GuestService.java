package com.hussain.hms.GuestManagementSystem.service;

import java.util.List;

import com.hussain.hms.GuestManagementSystem.model.GuestDetails;

public interface GuestService {

    List<GuestDetails> getAllGuests();

    GuestDetails getGuestById(String id);

    GuestDetails addGuest(GuestDetails guest);

    GuestDetails updateGuest(String id, GuestDetails guest);

    void deleteGuest(String id);
}
