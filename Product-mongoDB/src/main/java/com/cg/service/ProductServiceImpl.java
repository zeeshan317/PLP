package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductDao;
import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao dao;
	
	@Override
	public Product addProduct(Product product) {
		return dao.add(product);
	}

	@Override
	public Product getProduct(int id) throws ProductNotFoundException {
		return dao.get(id);
	}

	@Override
	public List<Product> getAllProduct() throws ProductNotFoundException {
		return dao.getAll();
	}

	@Override
	public Product updateProduct(Product product) {
		return dao.update(product);
	}

	@Override
	public boolean deleteProduct(int id) throws ProductNotFoundException {
		return dao.delete(id);
	}

	@Override
	public List<Product> getProductByPricerange(double min, double max) throws ProductNotFoundException {
		return dao.getByPricerange(min, max);
	}

	@Override
	public List<Product> getProductByName(String name) throws ProductNotFoundException {
		return dao.getByName(name);
	}

	@Override
	public List<Product> getProductByRating(double rating) throws ProductNotFoundException {
		return dao.getByRating(rating);
	}

}
