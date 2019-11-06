package com.cg.dao;

import java.util.List;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

public interface ProductDao {
	Product add(Product product);
	Product get(int id) throws ProductNotFoundException;
	List<Product> getAll() throws ProductNotFoundException;
	Product update(Product product);
	boolean delete(int id) throws ProductNotFoundException;
	List<Product> getByPricerange(double min,double max) throws ProductNotFoundException;
	List<Product> getByName(String name) throws ProductNotFoundException;
	List<Product> getByRating(double rating) throws ProductNotFoundException;
}
