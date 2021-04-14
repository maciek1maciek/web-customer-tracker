package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Override
	@Transactional 		//no need to write begin.transaition and close transmission
	public List<Customer> getCustomer(){
		
		//get the curreent hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery =
					currentSession.createQuery("from Customer",Customer.class);
		//excetute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		
		return customers;
	}
	
	//Inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
		
	
}
