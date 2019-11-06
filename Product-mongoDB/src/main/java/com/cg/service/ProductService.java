package com.cg.service;

import java.util.List;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductService {
	Product addProduct(Product product);
	Product getProduct(int id) throws ProductNotFoundException;
	List<Product> getAllProduct() throws ProductNotFoundException;
	Product updateProduct(Product product);
	boolean deleteProduct(int id) throws ProductNotFoundException;
	List<Product> getProductByPricerange(double min,double max) throws ProductNotFoundException;
	List<Product> getProductByName(String name) throws ProductNotFoundException;
	List<Product> getProductByRating(double rating) throws ProductNotFoundException;

}
