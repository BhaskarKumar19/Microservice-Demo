package com.hmsi.mdhonda.quoteService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle_Detail")
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id ;
	
	@Column(name="model")
	String model;
	
	@Column(name="varient")
	String varient; 
	
	@Column(name="color")
	String color;
	
	public Vehicle() {}

	public Vehicle(int id, String model, String varient, String color) {
		super();
		this.id = id;
		this.model = model;
		this.varient = varient;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVarient() {
		return varient;
	}

	public void setVarient(String varient) {
		this.varient = varient;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}
