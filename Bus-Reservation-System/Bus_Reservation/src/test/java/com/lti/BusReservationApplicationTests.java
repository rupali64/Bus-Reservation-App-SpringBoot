package com.lti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.entity.Admin;
import com.lti.entity.Booking;
import com.lti.entity.Payment;
import com.lti.entity.Schedule;
import com.lti.entity.User;
import com.lti.exception.AdminNotFoundException;
import com.lti.exception.BookingNotFoundException;
import com.lti.exception.PaymentNotFoundException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.AdminService;
import com.lti.service.BookingService;
import com.lti.service.BusService;
import com.lti.service.PaymentService;
import com.lti.service.ScheduleService;
import com.lti.service.UserService;


@SpringBootTest
class BusReservationApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired 
	UserService userservice;
	
	@Autowired
	ScheduleService scheduleservice;
	
	@Autowired 
	PaymentService paymentservice;
	
	@Autowired
	BusService busservice;
	
	@Autowired
	BookingService bookingservice;
	
	@Autowired
	AdminService adminservice;
	
	@Test
	void createUserTest() {
		User user = new User();
		user.setUserId(1);
		user.setUserName("Rupali123");
		user.setFullName("Rupali Sharma");
		user.setPassword("abc");
		user.setGender("Female");
		user.setEmail("rupali2.sharma@lntinfotech.com");
		user.setContactNo("7889593886");
		
		try {
			assertEquals(user.getEmail(), userservice.createUser(user).getEmail());
		} catch (Exception e) {
			
			e.printStackTrace();
		}					
		}
	
	@Test
	void getByIdTest() throws UserNotFoundException  {
	    User user = new User();
		user.setUserId(1);
		user.setUserName("Rupali123");
		user.setPassword("abc");
		user.setEmail("rupali2.sharma@lntinfotech.com");
		user.setContactNo("7889593886");
		assertEquals(user.getUserId(), userservice.findUserById(user.getUserId()));
	}
	
	@Test
	void addAdminTest() {
		Admin admin = new Admin();
		admin.setAdminId(1);
		admin.setAdminName("Rupali");
		admin.setPassword("abc");
		admin.setEmail("rupali2.sharma@lntinfotech.com");
		
		try {
			assertEquals(admin.getAdminId(), adminservice.addAdmin(admin).getAdminId());
		} catch (Exception e) {
			
			e.printStackTrace();
		}					
		}
		
	@Test
	void addScheduleTest() {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(1);
		schedule.setStartingPoint("Pune");
		schedule.setDestination("Mumbai");
		schedule.setFareAmount(2000);
		schedule.setEstimatedArrivalTime("5:30");
		schedule.setDepartureTime("1:30");
		schedule.setScheduleDate("31-09-2022");
		assertEquals(schedule.getScheduleId(),scheduleservice.addScheduledBus(schedule).getScheduleId());
		
	}
	
	@Test
	void AdminByIdTest() throws AdminNotFoundException  {
		    Admin admin = new Admin();
			admin.setAdminId(1);
			admin.setAdminName("Rupali");
			admin.setPassword("abc");
			admin.setEmail("rupali2.sharma@lntinfotech.com");
			
			assertEquals(admin.getAdminId(), adminservice.findAdminById(admin.getAdminId()));
		}
	
	
	@Test
	void addBooking() {
		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setBookingStatus("Completed");
		booking.setFareAmount(2000.00);
		booking.setNoOfSeats(4);
		booking.setTotalAmount(8000);
		
		assertEquals(booking.getBookingId(),bookingservice.createBooking(booking).getBookingId());
}

	
	@Test
	void BookingByIdTest() throws BookingNotFoundException {
		Booking booking = new Booking();
		booking.setBookingId(1);
		booking.setBookingStatus("Completed");
		booking.setFareAmount(2000.00);
		booking.setNoOfSeats(4);
		booking.setTotalAmount(8000);
		
		assertEquals(booking.getBookingId(),bookingservice.findBookingById(booking.getBookingId()));
}
	
	@Test
	void addPaymentTest() {
		Payment payment = new Payment();
		payment.setPaymentId(1);
		payment.setPaymentMethod("Wallet");
		payment.setAmountPaid(2000.00);
		assertEquals(payment.getPaymentId(),paymentservice.addPayment(payment).getPaymentId());
		}
	
	@Test 
	void PaymentByIdTest() throws PaymentNotFoundException{
		Payment payment = new Payment();
		payment.setPaymentId(1);
		payment.setPaymentMethod("Wallet");
		payment.setAmountPaid(2000.00);
		assertEquals(payment.getPaymentId(),paymentservice.findPaymentById(payment.getPaymentId()));
		
	}
}
