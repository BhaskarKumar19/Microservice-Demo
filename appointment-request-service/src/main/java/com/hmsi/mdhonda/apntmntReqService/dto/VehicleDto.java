package com.hmsi.mdhonda.apntmntReqService.dto;

public class VehicleDto {

	int id;
	String model;
	String varient;
	String color;

	public VehicleDto() {
	}

	public VehicleDto(int id, String model, String varient, String color) {
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
