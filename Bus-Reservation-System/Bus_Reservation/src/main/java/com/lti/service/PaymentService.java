package com.lti.service;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Payment;
import com.lti.exception.PaymentNotFoundException;

public interface PaymentService {
	
	List <Payment> getAllPaymentDetails();
	Payment findPaymentById(int paymentid) throws PaymentNotFoundException ;
	Payment addPayment(Payment newPayment);

}