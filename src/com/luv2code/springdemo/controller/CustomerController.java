package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get the customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer theCustomer = new Customer();
		model.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		
		//saving customer to DB
		customerService.saveCustomer(customer);
		
		
		return "redirect:/customer/list";		//return to list customer
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,
									Model model) {
		//get customer from DB (SERVICE)
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model to set beginning value o form
		
		model.addAttribute("customer",theCustomer);
		
		//send to our form
		
		return "customer-form";
	}
	
	
	
	
	
}
