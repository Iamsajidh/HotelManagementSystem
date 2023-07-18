package com.hussain.hms.ReceptionistEndUser.Controller;

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
import org.springframework.web.client.RestTemplate;

import com.hussain.hms.ReceptionistEndUser.Models.Reservation;
import com.hussain.hms.ReceptionistEndUser.Models.ReservationList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reservation")
public class ReceptionistReservationController {

	@Autowired
	RestTemplate rest;


	@PostMapping("/addReservation")
	public String addReservation(@RequestBody Reservation book) {
		return rest.postForObject("http://localhost:8083/reservation/addReservation/", book, String.class);

	}

	@PutMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody Reservation book) {
		rest.put("http://localhost:8083/reservation/updateReservation/", book, Reservation.class);
		return book;
	}

	@DeleteMapping("/cancelReservation/{id}")
	public String deleteReservation(@PathVariable("id") String id) {
		rest.delete("http://localhost:8083/reservation/cancelReservation/" + id);
		return "Deleted room " + id;
	}

	@GetMapping("/ShowAllReservations")
	public ReservationList getResList() {
		return rest.getForObject("http://localhost:8083/reservation/ShowAllReservations/",
				ReservationList.class);
	}

	@GetMapping("/getByreservation/{id}")
	public Reservation getReservation(@PathVariable("id") String id) {
		return rest.getForObject("http://localhost:8083/reservation/getByreservation/" + id, Reservation.class);

	}

}