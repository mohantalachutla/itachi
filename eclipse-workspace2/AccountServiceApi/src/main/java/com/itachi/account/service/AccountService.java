package com.itachi.account.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.itachi.account.model.Customer;
import com.itachi.account.repository.CustomerRepository;

@Service
@Scope(value="singleton") //default
public class AccountService {
	Logger log = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	CustomerRepository repo;
	
	
	public Boolean registerCustomer(Customer cust)
	{
		Optional<Customer> cust1 = repo.getCustomerByMail(cust.getMail());
		if(cust1.isEmpty())
		{
			repo.save(cust);
			return true;
		}
		log.debug("cust{}",cust.toString());
		log.debug("cust{}",cust1.toString());
		return false;
	}
	public Boolean loginCustomer(String mail,String password)
	{
		Optional<Customer> cust = repo.getCustomerByMail(mail);
		if(!cust.isEmpty() && cust.get().getPassword().equals(password))
		{
			log.debug(cust.get().toString());
			return true;
		}
		return false;
	}
	public Boolean deleteCustomer(String mail,String password)
	{
		Optional<Customer> cust = repo.getCustomerByMail(mail);
		log.debug(cust.get().toString());
		if(!cust.isEmpty() && cust.get().getPassword().equals(password))
		{
			repo.delete(cust.get());
			return true;
		}
		return false;
	}

}
