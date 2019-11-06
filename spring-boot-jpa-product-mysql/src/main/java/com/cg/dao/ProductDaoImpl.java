package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private EntityManager mgr;
	
	@Override
	public Product save(Product product) {
		mgr.persist(product);
		return product;
	}

	@Override
	public Product fetch(int id) throws ProductNotFoundException {
		Product p = mgr.find(Product.class, id);
		if(p == null) 
			throw new ProductNotFoundException("No record found for Id: " + id);
		return p;
	}

	@Override
	public List<Product> fetchAll() {
		return mgr.createNamedQuery("allProducts").getResultList();
	}

	@Override
	public Product update(Product product) {
		mgr.merge(product);
		return product;
	}

	@Override
	public boolean remove(int id) throws ProductNotFoundException {
		Product p = mgr.find(Product.class, id);
		if(p == null)
			throw new ProductNotFoundException("Invalid product Id: " + id);
		mgr.remove(p);
		return true;
	}

	@Override
	public List<Product> byCategory(String cat) {
		return mgr.createNamedQuery("byCategory").setParameter("cat", cat).getResultList();
	}

	@Override
	public List<Product> byPriceRange(double min, double max) {
		return mgr.createNamedQuery("byRange").setParameter("min", min).setParameter("max", max).getResultList();
	}

	@Override
	public List<Product> sortByPrice() {
		return mgr.createNamedQuery("sortByPrice").getResultList();
	}

}
