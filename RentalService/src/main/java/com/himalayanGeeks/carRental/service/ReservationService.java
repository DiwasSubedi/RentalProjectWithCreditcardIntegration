package com.himalayanGeeks.carRental.service;

import java.util.List;

import com.himalayanGeeks.carRental.domain.Insurance;
import com.himalayanGeeks.carRental.domain.Reservation;

public interface ReservationService {
	
	Reservation save(Reservation reservation);
	Reservation getRes(int id);
    List<Reservation> getAllReservation();

}
