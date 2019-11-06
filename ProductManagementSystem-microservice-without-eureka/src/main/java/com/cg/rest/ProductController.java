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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
		return service.fetchProductById(id);
	}
	
	@GetMapping(value = "getAll", produces = "application/json")
	public List<Product> getAllProduct() {
		return service.fetchAllProduct();
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public Product updateProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean removeProduct(@RequestParam int id) throws ProductNotFoundException {
		return service.removeProduct(id);
	}
	
	@GetMapping(value = "pricerange", produces = "application/json")
	public List<Product> getProductByPriceRange(@RequestParam double min, @RequestParam double max) throws ProductNotFoundException {
		return service.fetchProductByPriceRange(min, max);
	}
	
	@GetMapping(value = "name/{name}", produces = "application/json")
	public Product getProductByName(@PathVariable String name) throws ProductNotFoundException {
		return service.fetchProductByProductName(name);
	}
	
	@GetMapping(value = "quantity/{quantity}", produces = "application/json")
	public List<Product> getProductByQuantity(@PathVariable int quantity) throws ProductNotFoundException {
		return service.fetchProductByProductQuantity(quantity);
	}
}
