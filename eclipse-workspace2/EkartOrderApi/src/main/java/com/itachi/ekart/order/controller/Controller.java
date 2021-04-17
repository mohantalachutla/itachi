package com.itachi.ekart.order.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itachi.ekart.order.model.OrderDetails;
import com.itachi.ekart.order.model.OrderRequestHandler;
import com.itachi.ekart.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("OrderEndPoint")
@RestController
@RequestMapping("/order")
public class Controller {

	private static Logger logger = LoggerFactory.getLogger(Controller.class);
	@Autowired
	OrderService service;
	
	@Autowired
	Map<String,Object>	mResponse;
	List<OrderRequestHandler> lResponse;
	List<OrderDetails> lResponse2;
	Optional<OrderRequestHandler> opRh;
	Optional<OrderDetails> orderDetails;
	
	/*ResponseEntity,RequestEntity =& HttpEntity, HttpStatus, HttpMethod
	HttpEntity =& HttpHeader, body
	HttpHeader=& MultiValueMap*/
	
	
	@ApiOperation("book order")
	@PostMapping(value="/",consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<OrderRequestHandler>  bookOrder(@RequestBody OrderRequestHandler rh)
	{
		logger.debug("\n\n invoking bookingorder");
		try {
			mResponse = service.bookOrder(rh);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(rh);
	}
	
	@ApiOperation("get all order details")
	@GetMapping(value="/")
	public ResponseEntity<List<OrderDetails>>  getAllOrderDetails()
	{
		logger.debug("\n\n invoking getAllOrderDetails");
		try {
			lResponse2 = service.getAllOrderDetails();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lResponse2);
	}
	@ApiOperation("delete all order details")
	@DeleteMapping(value="/")
	public ResponseEntity<String>  deleteAllOrderDetails()
	{
		logger.debug("\n\n invoking getAllOrderDetails");
		try {
			service.deleteAllOrderDetails();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("OK");
	}
	@ApiOperation("get order details by id")
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<OrderDetails>>  getOrderDetailsById(@PathVariable String id)
	{
		logger.debug("\n\n invoking getOrderDetailsById");
		try {
			orderDetails = service.getOrderDetailsById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(orderDetails);
	}
	@ApiOperation("delete order details by id")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String>  deleteOrderDetailsById(@PathVariable String id)
	{
		logger.debug("\n\n invoking getOrderDetailsById");
		try {
			service.deleteOrderDetailsById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("OK");
	}
	@ApiOperation("test")
	@GetMapping(value="/test")
	public ResponseEntity<String> test()
	{
		return ResponseEntity.ok("Ekart Order Api");
	}
}
