package com.hmsi.mdhonda.quoteService.dto;

import com.hmsi.mdhonda.quoteService.entities.Customer;
import com.hmsi.mdhonda.quoteService.entities.Vehicle;

public class QuoteDto {
	int id;
	Vehicle vehicle;
	Customer customer;
	String comment;

	public QuoteDto() {
	}
	
	public QuoteDto(int id, Vehicle vehicle, Customer customer, String comment) {
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
