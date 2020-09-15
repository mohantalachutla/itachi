package com.itachi.ekart.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itachi.ekart.payment.model.PaymentDetails;

public interface PayementRepository extends JpaRepository<PaymentDetails, String>{
	
}
