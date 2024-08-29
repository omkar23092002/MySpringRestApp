package com.wu.MySpringApp.SpringProject.dao;


import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wu.MySpringApp.SpringProject.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class CustomerDAO {
    
	private EntityManager entityManager;
	 
	public CustomerDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	@Transactional
	public ArrayList<Customer> getCustomers() {
		// TODO Auto-generated method stub
//		ArrayList<Customer>list= new ArrayList<>();
//		Customer c1 =  new Customer(1,"Omkar Rasal","myemai.com");
//		
//		list.add(c1);
//				
		
		
		//return list;
		
		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("from Customer", Customer.class);

		ArrayList<Customer> list = (ArrayList<Customer>) query.getResultList();
       System.out.println(list);
		return list;
		
		
		
	}



	public Customer getCustomerById(int custId) {
		// TODO Auto-generated method stub
		Session session =entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, custId);
		return customer;
	}


       @Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
    	   
    	   Session session = entityManager.unwrap(Session.class);
    	   session.save(customer);
    	   
		
	}


     @Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Session session =  entityManager.unwrap(Session.class);
		session.update(customer);
		
		
	}
	
     
     @Transactional 
     public void deleteCustomer(int custId) {
    	 
    	 Customer customer = getCustomerById(custId);
    	 
    		Session session =  entityManager.unwrap(Session.class);
    		session.delete(customer);
    		
    	 
    	 
    	 
     }
	
}
