package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BookingDao;
import com.lti.entity.Admin;
import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.exception.AdminNotFoundException;
import com.lti.exception.BookingNotFoundException;
import com.lti.exception.BusNotFoundException;

@Service
public class BookingServiceImpl  implements BookingService{
	
	@Autowired
	BookingDao bookingdao;
 
	@Override
	public List<Booking> getAllBookingDetails() {
		// TODO Auto-generated method stub
		return bookingdao.findAll();
	}

	@Override
	@Transactional
     public Booking createBooking(Booking newBooking) {
		return bookingdao.save(newBooking);		
	}
	
	@Override
	public Booking updateBooking(Booking changedBooking) {
		
	
		Optional<Booking> findBookingById = bookingdao.findById(changedBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingdao.save(changedBooking);
		} 
		return changedBooking;
	}


	@Override

	public String deleteBooking(int bookingId) {
		Optional<Booking> findBookingById = bookingdao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingdao.deleteById(bookingId);
		}
			return "Booking Deleted!!";
		
	}

	@Override
	public Booking findBookingById(int bookingId) throws BookingNotFoundException {
		Optional<Booking> booking = bookingdao.findById(bookingId);
		if(!(booking.isPresent())) {
			throw new BookingNotFoundException("Booking id: " + bookingId + "not found");
		}
	return booking.get();
	}
	}

