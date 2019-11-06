package com.cg.service;

import java.util.List;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductService {

	Product saveProduct(Product product);
	
	Product fetchProduct(int id) throws ProductNotFoundException;
	
	List<Product> fetchAllProduct();
	
	Product updateProduct(Product product);
	
	boolean removeProduct(int id) throws ProductNotFoundException;
	
	List<Product> fetchProductByCategory(String cat);
	
	List<Product> fetchProductByPriceRange(double min, double max);
	
	List<Product> sortProductByPriceRange();
	
	
}
