package com.hmsi.mdhonda.quoteService.dto;

public class QuoteDto {
	int id;
	CatalogDto catalog;
	CustomerDto customer;
	String comment;

	public QuoteDto() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public CatalogDto getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogDto catalog) {
		this.catalog = catalog;
	}

	

}
