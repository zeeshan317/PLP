package com.cg.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	@Id
	private int productId;
	private String productName;
	private String productCategory;
	private double productPrice;
	private int productQuantity;
	
	public Product() {
	}

	public Product(int productId, String produdctName, String productCategory, double productPrice,
			int productQuantity) {
		super();
		this.productId = productId;
		this.productName = produdctName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
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

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", produdctName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + "]";
	}
	
	
}
