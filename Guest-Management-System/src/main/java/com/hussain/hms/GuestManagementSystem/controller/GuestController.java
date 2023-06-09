package com.hussain.hms.GuestManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.GuestManagementSystem.model.GuestDetails;
import com.hussain.hms.GuestManagementSystem.service.GuestService;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public ResponseEntity<List<GuestDetails>> getAllGuests() {
        List<GuestDetails> guests = guestService.getAllGuests();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestDetails> getGuestById(@PathVariable String id) {
    	GuestDetails guest = guestService.getGuestById(id);
        if (guest != null) {
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<GuestDetails> addGuest(@RequestBody GuestDetails guest) {
    	GuestDetails addedGuest = guestService.addGuest(guest);
        return new ResponseEntity<>(addedGuest, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestDetails> updateGuest(@PathVariable String id, @RequestBody GuestDetails guest) {
    	GuestDetails updatedGuest = guestService.updateGuest(id, guest);
        if (updatedGuest != null) {
            return new ResponseEntity<>(updatedGuest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable String id) {
        guestService.deleteGuest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
