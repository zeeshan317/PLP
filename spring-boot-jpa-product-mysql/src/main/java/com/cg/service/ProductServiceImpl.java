package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.ProductDao;
import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

@Service
@Transactional(rollbackFor = ProductNotFoundException.class)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Product saveProduct(Product product) {
		return dao.save(product);
	}

	@Override
	public Product fetchProduct(int id) throws ProductNotFoundException {
		return dao.fetch(id);
	}

	@Override
	public List<Product> fetchAllProduct() {
		return dao.fetchAll();
	}

	@Override
	public Product updateProduct(Product product) {
		return dao.update(product);
	}

	@Override
	public boolean removeProduct(int id) throws ProductNotFoundException {
		dao.remove(id);
		return true;
	}

	@Override
	public List<Product> fetchProductByCategory(String cat) {
		return dao.byCategory(cat);
	}

	@Override
	public List<Product> fetchProductByPriceRange(double min, double max) {
		return dao.byPriceRange(min, max);
	}

	@Override
	public List<Product> sortProductByPriceRange() {
		return dao.sortByPrice();
	}

}
