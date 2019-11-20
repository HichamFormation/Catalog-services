package org.cap.entities;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document
@ToString
public class Category {
    
	@Id
	private String id;
	private String nameCat;
	@DBRef
	private Collection<Product> products=new ArrayList<Product>();
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", nameCat=" + nameCat + ", products=" + products + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String nameCat, Collection<Product> products) {
		super();
		this.id = id;
		this.nameCat = nameCat;
		this.products = products;
	}
}
