package com.hussain.hms.GuestManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussain.hms.GuestManagementSystem.model.GuestDetails;
import com.hussain.hms.GuestManagementSystem.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<GuestDetails> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public GuestDetails getGuestById(String id) {
        return guestRepository.findById(id).orElse(null);
    }

    @Override
    public GuestDetails addGuest(GuestDetails guest) {
        return guestRepository.save(guest);
    }

    @Override
    public GuestDetails updateGuest(String id, GuestDetails guest) {
        if (guestRepository.existsById(id)) {
            guest.setId(id);
            return guestRepository.save(guest);
        }
        return null;
    }

    @Override
    public void deleteGuest(String id) {
        guestRepository.deleteById(id);
    }
}
