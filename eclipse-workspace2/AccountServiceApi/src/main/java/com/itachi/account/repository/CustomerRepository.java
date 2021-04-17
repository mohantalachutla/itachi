package com.itachi.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itachi.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	//public Type action+Classname+By+Fieldsname	should follow exact format
	public Optional<Customer> getCustomerByMail(String mail); //jpa works in the form of abstract methods internally
	public Optional<Customer> getCustomerById(int id);
	public Optional<Customer> deleteCustomerById(int id);
}
