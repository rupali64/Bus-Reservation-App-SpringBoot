package com.lti.service;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.PaymentDao;
import com.lti.entity.Admin;
import com.lti.entity.Payment;
import com.lti.exception.PaymentNotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	
	@Autowired 
	PaymentDao paymentdao;

	@Override
	public List<Payment> getAllPaymentDetails() {
		return paymentdao.findAll();
	}

	@Override
	public Payment findPaymentById(int paymentid) throws PaymentNotFoundException {
		Optional<Payment> payment = paymentdao.findById(paymentid);

		if(!(payment.isPresent())) {
			throw new PaymentNotFoundException("Payment id: " + paymentid + "is not done");
		}
	return payment.get();
	}

	@Override
	@Transactional
	public Payment addPayment(Payment newPayment) {
		return paymentdao.save(newPayment);		
	}
	

}
