package com.hussain.hms.ReservationMicroservice.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hussain.hms.ReservationMicroservice.Models.Reservation;
import com.hussain.hms.ReservationMicroservice.Models.ReservationList;
import com.hussain.hms.ReservationMicroservice.Services.ReservationService;
import com.hussain.hms.ReservationMicroservice.Exception.ReservationNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping("/addReservation")
    public String addReservation(@RequestBody Reservation book) {
        return service.addReservation(book);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation book) {
        return service.updateReservation(book);
    }

    @DeleteMapping("/cancelReservation/{id}")
    public String deleteReservation(@PathVariable("id") String id) {
        try {
            return service.deleteReservation(Long.parseLong(id));
        } catch (ReservationNotFoundException ex) {
            throw new ReservationNotFoundException("Reservation not found with ID: " + id);
        }
    }

    @GetMapping("/ShowAllReservations")
    public ReservationList getResList() {
        ReservationList list = new ReservationList();
        list.setResList(service.getResList());
        return list;
    }

    @GetMapping("/getByreservation/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") String id) {
        return service.getReservation(Long.parseLong(id));
    }
}
