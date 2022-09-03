package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "booking_details")
public class Booking {
	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
//	@Column(name = "scheduleId")
//	private int scheduleId;
//	@Column(name = "userId")
//	private int userId;
	@Column(name = "seats")
	private int noOfSeats;
	@Column(name = "fare_amount")
	private double fareAmount;
	@Column(name = "total_amount")
	private double totalAmount;
	@Column(name = "dateofbooking")
	private String dateOfBooking;
	@Column(name = "booking_status")
	private String bookingStatus;
	
	@Autowired
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	
	@Autowired
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
	
	public Booking() {}
	
	public Booking(int noOfSeats, double fareAmount, double totalAmount, String dateOfBooking,
			String bookingStatus, User user, Schedule schedule) {
		this.noOfSeats = noOfSeats;
		this.fareAmount = fareAmount;
		this.totalAmount = totalAmount;
		this.dateOfBooking = dateOfBooking;
		this.bookingStatus = bookingStatus;
		this.user = user;
		this.schedule = schedule;
	}

	public Booking(int bookingId, int noOfSeats, double fareAmount, double totalAmount, String dateOfBooking,
			String bookingStatus, User user, Schedule schedule) {
		this.bookingId = bookingId;
		this.noOfSeats = noOfSeats;
		this.fareAmount = fareAmount;
		this.totalAmount = totalAmount;
		this.dateOfBooking = dateOfBooking;
		this.bookingStatus = bookingStatus;
		this.user = user;
		this.schedule = schedule;
	}


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getFareAmount() {
		return fareAmount;
	}

	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	public Schedule getSchedule() {
//		return schedule;
//	}
//
//	public void setSchedule(Schedule schedule) {
//		this.schedule = schedule;
//	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", noOfSeats=" + noOfSeats + ", fareAmount=" + fareAmount
				+ ", totalAmount=" + totalAmount + ", dateOfBooking=" + dateOfBooking + ", bookingStatus="
				+ bookingStatus + ", user=" + user + ", schedule=" + schedule + "]";
	}
	
}
