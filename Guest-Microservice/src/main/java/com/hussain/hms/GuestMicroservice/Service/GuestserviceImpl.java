package com.hussain.hms.GuestMicroservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hussain.hms.GuestMicroservice.Models.Guest;
import com.hussain.hms.GuestMicroservice.Repository.GuestRepository;

@Service
public class GuestserviceImpl implements Guestservice {

    private static final Logger logger = LoggerFactory.getLogger(GuestserviceImpl.class);

    @Autowired
    GuestRepository guestRepository;

    @Override
    public Guest addGuest(Guest guest) {
        logger.info("Adding guest: {}", guest);
        return guestRepository.insert(guest);
    }

    @Override
    public Guest updateGuest(Guest guest) {
        logger.info("Updating guest: {}", guest);
        return guestRepository.save(guest);
    }

    @Override
    public String deleteGuest(int id) {
        logger.info("Deleting guest with ID: {}", id);
        guestRepository.deleteById(id);
        return "Deleted Guest Id: " + id;
    }

    @Override
    public Optional<Guest> getGuest(int id) {
        logger.info("Retrieving guest with ID: {}", id);
        return guestRepository.findById(id);
    }

    @Override
    public List<Guest> getAllGuest() {
        logger.info("Retrieving all guests");
        return guestRepository.findAll();
    }
}
