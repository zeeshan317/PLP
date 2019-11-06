package com.cg.service;

import java.util.List;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductService {

	Product addProduct(Product product);
	
	Product fetchProductById(int id) throws ProductNotFoundException;
	
	List<Product> fetchAllProduct();
	
	Product updateProduct(Product product);
	
	boolean removeProduct(int id) throws ProductNotFoundException;
	
	List<Product> fetchProductByPriceRange(double min, double max) throws ProductNotFoundException;
	
	Product fetchProductByProductName(String name) throws ProductNotFoundException;
	
	List<Product> fetchProductByProductQuantity(int quantity) throws ProductNotFoundException;
}
