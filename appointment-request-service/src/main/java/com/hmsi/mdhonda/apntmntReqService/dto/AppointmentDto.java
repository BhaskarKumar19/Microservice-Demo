package com.hmsi.mdhonda.apntmntReqService.dto;

import java.util.Date;

public class AppointmentDto {
	int id;
	VehicleDto vehicleDto;
	CustomerDto customerDto;
	String comment;	
	Long registrationNo;
	Long serialNo;
	Date preferrdDate;
	String time;

	public AppointmentDto() {
	}
	
	public AppointmentDto(int id, VehicleDto vehicle, CustomerDto customer, String comment, Long registrationNo,
			Long serialNo, Date preferrdDate, String time) {
		super();
		this.id = id;
		this.vehicleDto = vehicle;
		this.customerDto = customer;
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

	public VehicleDto getVehicle() {
		return vehicleDto;
	}

	public void setVehicle(VehicleDto vehicle) {
		this.vehicleDto = vehicle;
	}

	public CustomerDto getCustomer() {
		return customerDto;
	}

	public void setCustomer(CustomerDto customer) {
		this.customerDto = customer;
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
