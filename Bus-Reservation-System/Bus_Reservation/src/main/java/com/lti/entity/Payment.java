package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private int paymentId;
//	@Column(name = "bookingId")
//	private int bookingId;
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	@Column(name = "payment_method")
	private String paymentMethod;
	@Column(name = "amount_paid")
	private double amountPaid;
	
	@Autowired
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	public Payment() {}
	
	public Payment(LocalDate paymentDate, String paymentMethod, double amountPaid, Booking booking) {
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.amountPaid = amountPaid;
		this.booking = booking;
	}

	

	public Payment(int paymentId, LocalDate paymentDate, String paymentMethod, double amountPaid, Booking booking) {
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
		this.amountPaid = amountPaid;
		this.booking = booking;
	}



	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

//	public Booking getBooking() {
//		return booking;
//	}
//
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentMethod=" + paymentMethod
				+ ", amountPaid=" + amountPaid + ", booking=" + booking + "]";
	}
	
}
