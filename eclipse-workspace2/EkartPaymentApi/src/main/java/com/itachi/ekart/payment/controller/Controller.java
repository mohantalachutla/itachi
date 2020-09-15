package com.itachi.ekart.payment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itachi.ekart.payment.model.PaymentDetails;
import com.itachi.ekart.payment.service.PaymentService;

import io.swagger.annotations.Api;

@Api("Payment Endpooint")
@RestController
@RequestMapping("/payment/")
public class Controller {
	@Autowired
	PaymentService service;
	Optional<PaymentDetails> pd;
	
	@PostMapping(value="/",consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public PaymentDetails postPayment(@RequestBody PaymentDetails pd)
	{
		try
		{
			pd = service.savePaymentDetails(pd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pd;
	}
	@GetMapping(value="/{id}")
	public Optional<PaymentDetails >getPayment(@PathVariable String id)
	{
		try
		{
			 pd= service.getPaymentDetailsById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pd;
	}
	@DeleteMapping(value="/{id}")
	public Optional<PaymentDetails >deletePayment(@PathVariable String id)
	{
		try
		{
			 pd= service.getPaymentDetailsById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pd;
	}
	
	@RequestMapping(value="/")
	public ResponseEntity<String> defaulter()
	{
		return ResponseEntity.ok("Ekart Payment Api");
	}
}
