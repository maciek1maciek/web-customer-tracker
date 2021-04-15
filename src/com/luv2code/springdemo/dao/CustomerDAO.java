package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {
	

	List<Customer> getCustomer();

	void saveCustomer(Customer customer);

	Customer getCustomers(int theId);

	
}
