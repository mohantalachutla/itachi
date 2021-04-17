package com.itachi.ekart.payment.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import io.swagger.annotations.ApiOperation;

@Api("Payment Endpooint")
@RestController
@RequestMapping("/payment")
public class Controller {
	private static Logger logger = LoggerFactory.getLogger(Controller.class);
	@Autowired
	PaymentService service;
	Optional<PaymentDetails> pd;
	
	@ApiOperation("make payment")
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
	@ApiOperation("get payment by id")
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
	@ApiOperation("delete payment by id")
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
	@ApiOperation("test")
	@GetMapping(value="/test")
	public ResponseEntity<String> test()
	{
		String msg = "Ekart Payment Api";
		logger.debug(msg);
		return ResponseEntity.ok(msg);
	}
}
