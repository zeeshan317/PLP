package com.cg.dao;

import java.util.List;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductDao {

	Product save(Product product);
	
	Product fetch(int id) throws ProductNotFoundException;
	
	List<Product> fetchAll();
	
	Product update(Product product);
	
	boolean remove(int id) throws ProductNotFoundException;
	
	List<Product> byCategory(String cat);
	
	List<Product> byPriceRange(double min, double max);
	
	List<Product> sortByPrice();
}
