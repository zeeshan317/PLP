package com.cg.dao;

import java.util.List;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;
import com.mongodb.client.result.DeleteResult;

@Repository
public class ProductDaoImpl implements ProductDao {

	private MongoTemplate mongotemplate;
	
	public ProductDaoImpl(MongoTemplate mongotemplate) {
		this.mongotemplate = mongotemplate;
	}
	
	@Override
	public Product add(Product product) {
		mongotemplate.save(product);
		return product;
	}

	@Override
	public Product get(int id) throws ProductNotFoundException {
		Product product = mongotemplate.findById(id, Product.class);
		if(product == null) {
			throw new ProductNotFoundException("Product not found with id "+id);
		}
		return product;
	}

	@Override
	public List<Product> getAll() throws ProductNotFoundException {
		List<Product> allProduct = mongotemplate.findAll(Product.class);
		if(allProduct.size() == 0) {
			throw new ProductNotFoundException("Product database empty");
		}
		return allProduct;
	}

	@Override
	public Product update(Product product) {
		mongotemplate.save(product);
		return product;
	}

	@Override
	public boolean delete(int id) throws ProductNotFoundException {
		Product product = mongotemplate.findById(id, Product.class);
		if(product == null) {
			throw new ProductNotFoundException("Product not found with id "+id);
		}
		DeleteResult result= mongotemplate.remove(product);
		return result.wasAcknowledged();
	}

	@Override
	public List<Product> getByPricerange(double min, double max) throws ProductNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("productPrice").gte(min).andOperator(Criteria.where("productPrice").lte(max)));
		List<Product> allProduct = mongotemplate.find(query, Product.class);
		if(allProduct.size() == 0) {
			throw new ProductNotFoundException("No product found in price range "+min+" and "+max);
		}
		return allProduct;
	}

	@Override
	public List<Product> getByName(String name) throws ProductNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("productName").is(name));
		List<Product> allProduct = mongotemplate.find(query, Product.class);
		if(allProduct.size() == 0)
			throw new ProductNotFoundException("No product found with name "+name);
		return allProduct;
	}

	@Override
	public List<Product> getByRating(double rating) throws ProductNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("productRating").is(rating));
		List<Product> allProduct = mongotemplate.find(query, Product.class);
		if(allProduct.size() == 0)
			throw new ProductNotFoundException("Product not found with rating "+rating);
		return allProduct;
	}

}
