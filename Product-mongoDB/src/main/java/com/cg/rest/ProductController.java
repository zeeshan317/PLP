package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping(value = "/id/{id}", produces = "application/json")
	Product getProduct(@PathVariable int id) throws ProductNotFoundException{
		return service.getProduct(id);
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	List<Product> getAllProduct() throws ProductNotFoundException{
		return service.getAllProduct();
	}
	
	@PutMapping(value = "/update",produces = "application/json" ,consumes = "application/json")
	Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	boolean deleteProduct(@PathVariable int id) throws ProductNotFoundException{
		return service.deleteProduct(id);
	}
	
	@GetMapping(value = "/{min}/{max}", produces = "application/json")
	List<Product> getProductByPricerange(@PathVariable double min,@PathVariable double max) throws ProductNotFoundException{
		return service.getProductByPricerange(min, max);
	}
	
	@GetMapping(value = "/name/{name}", produces = "application/json")
	List<Product> getProductByName(@PathVariable String name) throws ProductNotFoundException{
		return service.getProductByName(name);
	}
	
	@GetMapping(value = "/rating/{rating}", produces = "application/json")
	List<Product> getProductByRating(@PathVariable double rating) throws ProductNotFoundException{
		return service.getProductByRating(rating);
	}

}
