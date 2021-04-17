package com.itachi.ekart.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itachi.ekart.payment.model.PaymentDetails;
import com.itachi.ekart.payment.repo.PayementRepository;

@Service
public class PaymentService {
	@Autowired
	PayementRepository repo;
	
	public PaymentDetails savePaymentDetails(PaymentDetails pd) throws Exception
	{
			return repo.save(pd);
	}
	public Optional<PaymentDetails> getPaymentDetailsById(String id) throws Exception
	{
		return repo.findById(id);
	}
	public void deletePaymentDetailsById(String id) throws Exception //imple: neven delete a transaction instead reverse it.
	{
		repo.deleteById(id);
	}
}
