package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Override	
	public List<Customer> getCustomer(){
		
		//get the curreent hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query and sort by the last name
		Query<Customer> theQuery =
					currentSession.createQuery("from Customer order by firstName",
												Customer.class);
		//excetute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		
		return customers;
	}
	
	//Inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer customer) {
		
		//get the curreent hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
		//save and update customer into DB
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int theId) {
Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class,theId);
		
		return customer;
	}


	
	
		
	
}
