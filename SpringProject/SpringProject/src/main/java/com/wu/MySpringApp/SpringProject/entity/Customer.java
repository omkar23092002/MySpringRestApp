package com.wu.MySpringApp.SpringProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer2")
@SequenceGenerator(name = "mySequence", sequenceName = "customer_sequence", initialValue = 20, allocationSize = 1)


public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySequence")
	@Column(name="id")
	private int id ;
	@Column(name="name")
	private String name ;
	@Column(name="email")
	private String email;
	
	public Customer() {
		
	}
	
	public Customer(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
