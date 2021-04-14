package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	//inject customer DAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional //no need to write begin.transaition and close transmission
	public List<Customer> getCustomers() {
		return customerDAO.getCustomer();
	}
	
	
}
