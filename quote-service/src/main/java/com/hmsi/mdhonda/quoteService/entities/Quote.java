package com.hmsi.mdhonda.quoteService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Quote_Detail")
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	Vehicle vehicle;

	@OneToOne(cascade = {CascadeType.ALL})
	Customer customer;
	
	@Column(name="comment")
	String comment;
	
	public Quote() {}

	public Quote(int id, Vehicle vehicle, Customer customer, String comment) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.customer = customer;
		this.comment = comment;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	

}
