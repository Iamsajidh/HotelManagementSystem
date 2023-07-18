package com.hussain.hms.ReservationMicroservice.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hussain.hms.ReservationMicroservice.Models.Reservation;
import com.hussain.hms.ReservationMicroservice.Models.Room;
import com.hussain.hms.ReservationMicroservice.Repo.ReservationRepository;
import com.hussain.hms.ReservationMicroservice.Exception.ReservationNotFoundException;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationRepository repos;

    @Autowired
    private RestTemplate restTmp;

    @Override
    public String addReservation(Reservation book) {
        Room room = restTmp.getForObject("http://localhost:8084/rooms/findById/" + book.getRoomId(), Room.class);
        if (room != null && room.isRoomAvl()) {
            repos.insert(book);
            room.setRoomAvl(false);
            restTmp.put("http://localhost:8084/rooms/updateRoom", room);
            return "Room Number " + room.getRoomId() + " booked for Guest : ";
        } else {
            return "Room Already Booked";
        }
    }

    @Override
    public Reservation updateReservation(Reservation book) {
        logger.info("Updating reservation: {}", book);
        return repos.save(book);
    }

    @Override
    public String deleteReservation(long id) {
        Optional<Reservation> reservationOptional = repos.findById(id);
        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();
            Room room = restTmp.getForObject("http://localhost:8084/rooms/delete/" + reservation.getRoomId(), Room.class);
            if (room != null) {
                room.setRoomAvl(true);
                restTmp.put("http://localhost:8084/rooms/updateRoom", room);
            }
            repos.deleteById(id);
            return "Deleted Reservation ID: " + id;
        } else {
            throw new ReservationNotFoundException("Reservation not found with ID: " + id);
        }
    }

    @Override
    public List<Reservation> getResList() {
        logger.info("Retrieving all reservations");
        return repos.findAll();
    }

   
    @Override
    public Optional<Reservation> getReservation(long id) {
        logger.info("Retrieving reservation with ID: {}", id);
        return repos.findById(id);
    }
}
