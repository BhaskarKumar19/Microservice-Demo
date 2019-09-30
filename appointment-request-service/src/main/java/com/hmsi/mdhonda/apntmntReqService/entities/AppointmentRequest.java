package com.hmsi.mdhonda.apntmntReqService.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment_Request")
public class AppointmentRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	Vehicle vehicle;

	@OneToOne(cascade = {CascadeType.ALL})
	Customer customer;
	
	@Column(name="comment")
	String comment;
	
	@Column(name="registrationNo")
	Long registrationNo;
	
	@Column(name="serialNo")
	Long serialNo;
	
	@Column(name="preferrdDate")
	Date preferrdDate;
	
	@Column(name="time")
	String time;

	
	public AppointmentRequest() {}

	public AppointmentRequest(int id, Vehicle vehicle, Customer customer, String comment, Long registrationNo,
			Long serialNo, Date preferrdDate, String time) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.customer = customer;
		this.comment = comment;
		this.registrationNo = registrationNo;
		this.serialNo = serialNo;
		this.preferrdDate = preferrdDate;
		this.time = time;
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

	public Long getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Long registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public Date getPreferrdDate() {
		return preferrdDate;
	}

	public void setPreferrdDate(Date preferrdDate) {
		this.preferrdDate = preferrdDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	

}
