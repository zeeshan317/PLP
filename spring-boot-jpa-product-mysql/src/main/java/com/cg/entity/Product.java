package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "prseq", sequenceName = "product_seq", allocationSize = 1)
@NamedQuery(name = "allProducts", query = "SELECT p FROM Product p")
@NamedQuery(name = "byCategory", query = "SELECT p FROM Product p WHERE p.category=:cat")
@NamedQuery(name = "byRange", query = "SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
@NamedQuery(name = "sortByPrice", query = "SELECT p FROM Product p ORDER BY p.price")
public class Product {

	@Id
	@GeneratedValue(generator = "prseq")
	private int id;
	@Column(length = 10)
	private String name;
	@Column(length = 10)
	private String category;
	private double price;
	private int rating;
	private int stock;
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
