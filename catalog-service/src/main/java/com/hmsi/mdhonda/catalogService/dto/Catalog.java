package com.hmsi.mdhonda.catalogService.dto;

public class Catalog {

	int id;
	String name;
	String description;
	String category;
	String imageUrl;
	
	public Catalog() {}
	
	public Catalog(int id, String name, String description, String category, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.imageUrl = imageUrl;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
