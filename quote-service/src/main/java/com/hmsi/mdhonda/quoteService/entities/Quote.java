package com.hmsi.mdhonda.quoteService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.ReadOnlyProperty;

@Entity
@Table(name = "Quote_Detail")
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	
	@OneToOne
	@JoinColumn(name="product_catalog_id", updatable=false, insertable=false)
	ProductCatalog catalog;

	@OneToOne(cascade = {CascadeType.ALL})
	Customer customer;
	
	@Column(name="comment")
	String comment;
	
	public Quote() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ProductCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(ProductCatalog catalog) {
		this.catalog = catalog;
	}

	


}
