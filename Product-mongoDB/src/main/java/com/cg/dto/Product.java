package com.cg.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "product")
public class Product {
	@Id
	private int productId;
	private String productName;
	private double productRating;
	private double productPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, double productRating, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productRating = productRating;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductRating() {
		return productRating;
	}

	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}
