package com.himalayanGeeks.carRental.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himalayanGeeks.carRental.domain.Reservation;
import com.himalayanGeeks.carRental.repository.ReservationRepo;
import com.himalayanGeeks.carRental.service.ReservationService;
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	
	@Autowired
	ReservationRepo rrepo;
	@Override
	public Reservation save(Reservation reservation) {
		return rrepo.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservation() {
		return (List<Reservation>) rrepo.findAll();
	}

	@Override
	public Reservation getRes(int id) {
		return rrepo.findOne(id);
		
	}
	

}
