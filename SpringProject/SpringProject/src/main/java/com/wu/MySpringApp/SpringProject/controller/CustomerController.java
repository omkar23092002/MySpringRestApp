package com.wu.MySpringApp.SpringProject.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.MySpringApp.SpringProject.dao.CustomerDAO;
import com.wu.MySpringApp.SpringProject.entity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {

	private CustomerDAO custDao;
	
	
	
//	public CustomerController() {
//	
//	}

	public CustomerController(CustomerDAO custDao) {
		this.custDao=custDao;
	}
	
	

	@GetMapping("/customers")
	public ArrayList<Customer> getCustomers(){
		
		return  custDao.getCustomers();
		
	}
	
	//Path variable is used for dynamic url mapping 
	@GetMapping("/customers/{custId}")
	public Customer getCustomerById(@PathVariable int custId) {
		
		return custDao.getCustomerById(custId);
	}
	
	
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer ) {
		
		custDao.addCustomer(customer);
		
		return "success";
		
	}
	
	@PutMapping("/updateCustomer")
	public String updatCustomer(@RequestBody Customer customer ) {
		
		custDao.updateCustomer(customer);
		return "updated customer";
		
	}
	
	
	@DeleteMapping("/deleteCustomer/{custId}")
	public String deleteCustomer(@PathVariable int custId) {
		
		custDao.deleteCustomer(custId);
		
		return "customer deleted with id "+ custId ;
	}
	
	
	
	  

	
}
