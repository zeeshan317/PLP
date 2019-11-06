package com.cg.dao;

import java.util.List;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductDao {

	Product saveProduct(Product product);
	
	Product getProductById(int id) throws ProductNotFoundException;
	
	List<Product> getAllProduct();
	
	Product updateProduct(Product product);
	
	boolean deleteProduct(int id) throws ProductNotFoundException;
	
	List<Product> getProductByPriceRange(double min, double max) throws ProductNotFoundException;
	
	Product getProductByProductName(String name) throws ProductNotFoundException;
	
	List<Product> getProductByProductQuantity(int quantity) throws ProductNotFoundException;
}
