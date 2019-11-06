package com.cg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;
import com.mongodb.client.result.DeleteResult;

@Repository
public class ProductDaoImpl implements ProductDao {

	private MongoTemplate mongoTemplate;
	
	@Autowired
	public ProductDaoImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Product saveProduct(Product product) {
		mongoTemplate.save(product);
		return product;
	}

	@Override
	public Product getProductById(int id) throws ProductNotFoundException {
		Product p = mongoTemplate.findById(id, Product.class);
		if(p == null)
			throw new ProductNotFoundException("No product found for id: " + id);
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		return mongoTemplate.findAll(Product.class);
	}

	@Override
	public Product updateProduct(Product product) {
		mongoTemplate.save(product);
		return product;
	}

	@Override
	public boolean deleteProduct(int id) throws ProductNotFoundException {
		Product p = mongoTemplate.findById(id, Product.class);
		if(p == null)
			throw new ProductNotFoundException("Invalid product id: " + id);
		DeleteResult result = mongoTemplate.remove(p);
		return result.wasAcknowledged();
	}

	@Override
	public List<Product> getProductByPriceRange(double min, double max) throws ProductNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("productPrice").gt(min).andOperator(Criteria.where("productPrice").lt(max)));
		List<Product> products = mongoTemplate.find(query, Product.class);
		if(products == null || products.size()==0)
			throw new ProductNotFoundException("No record found for the given price range.");
		return products;
	}

	@Override
	public Product getProductByProductName(String name) throws ProductNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("productName").is(name));
		Product p = mongoTemplate.findOne(query, Product.class);
		if(p == null)
			throw new ProductNotFoundException("No record found for name: " + name);
		return p;
	}

	@Override
	public List<Product> getProductByProductQuantity(int quantity) throws ProductNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("productQuantity").is(quantity));
		List<Product> products = mongoTemplate.find(query, Product.class);
		if(products == null || products.size()==0)
			throw new ProductNotFoundException("No product found for the given quantity.");
		return products;
	}

}
