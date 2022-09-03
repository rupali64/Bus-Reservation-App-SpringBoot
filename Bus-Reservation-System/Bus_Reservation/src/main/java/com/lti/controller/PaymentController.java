
package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Payment;
import com.lti.entity.User;
import com.lti.exception.PaymentNotFoundException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("http://localhost:4200")
public class PaymentController {
	
	@Autowired
	PaymentService paymentservice;
	
	@GetMapping("/displayAllPayments")
	public Iterable<Payment> AllPaymentDetails() {

		return paymentservice.getAllPaymentDetails();
	}
	
	@PostMapping("/addpayments")
	public Payment addPayment(@RequestBody Payment newPayment) {

		return paymentservice.addPayment(newPayment);
	}
	
	@GetMapping("/searchPayment/{id}")
	public Payment searchPaymentByID(@PathVariable("id") int paymentid) throws PaymentNotFoundException {

		return paymentservice.findPaymentById(paymentid);
	}
	
}