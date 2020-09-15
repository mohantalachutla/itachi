package com.itachi.account.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itachi.account.model.Customer;
import com.itachi.account.service.AccountService;

@RequestMapping("/account")
@RestController
public class Controller {
	
	Logger log = LoggerFactory.getLogger(Controller.class);
	@Autowired
	AccountService service;
	
	@PostMapping("/register")
	public Boolean registerCustomer(@RequestBody Customer cust)
	{
		log.debug(cust.toString());
		return service.registerCustomer(cust);
	}
	@PostMapping("/login")
	public Boolean loginCustomer(@RequestParam String mail, @RequestParam  String password)
	{
		log.debug("mail:{}, pass:{}",mail,password);
		return service.loginCustomer(mail,password);
	}
	@DeleteMapping("/delete")
	public Boolean deleteCustomer(@RequestParam String mail, @RequestParam  String password)
	{
		log.debug("mail:{}, pass:{}",mail,password);
		return service.deleteCustomer(mail,password);
	}
}
