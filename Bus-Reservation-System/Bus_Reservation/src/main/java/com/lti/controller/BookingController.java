package com.lti.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Booking;
import com.lti.exception.BookingNotFoundException;
import com.lti.exception.BusNotFoundException;
import com.lti.service.BookingService;


@CrossOrigin("http://localhost:4200")
@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired(required=true)
	BookingService bookingService;
	
	@PostMapping("/createBooking")
	public Booking addBooking(@RequestBody Booking newBooking) {

		return bookingService.createBooking(newBooking);
	}
	
	@GetMapping("/readAllBooking")
	public Iterable<Booking> readAllBookings() {

		return bookingService.getAllBookingDetails();
	}
	
	@PutMapping("/updateBooking")
	//@ExceptionHandler(BusNotFoundException.class)
	public void modifyBooking(@RequestBody Booking updateBooking) {

		bookingService.updateBooking(updateBooking);
	}
	
	@GetMapping("/searchBooking/{id}")
	//@ExceptionHandler(BusNotFoundException.class)
	public Booking searchBookingByID(@PathVariable("id") int bookingId) throws BookingNotFoundException {

		return bookingService.findBookingById(bookingId);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	//@ExceptionHandler(BusNotFoundException.class)
	public void deleteBookingByID(@PathVariable("id") int bookingId) {

		bookingService.deleteBooking(bookingId);
	}
}
