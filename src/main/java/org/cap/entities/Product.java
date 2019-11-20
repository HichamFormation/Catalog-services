package org.cap.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document
@ToString
public class Product {
	
    @Id
	private String id;
	private String nameProd;
	private double price;
	
	@DBRef
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(String id, String nameProd, double price, Category category) {
		super();
		this.id = id;
		this.nameProd = nameProd;
		this.price = price;
		this.category = category;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNameProd() {
		return nameProd;
	}



	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
			
}
