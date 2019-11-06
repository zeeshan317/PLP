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

import com.cg.entity.Product;
import com.cg.exception.ProductNotFoundException;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
		return service.fetchProduct(id);
	}
	
	@GetMapping(produces = "application/json")
	public List<Product> getAllProduct() {
		return service.fetchAllProduct();
	}
	
	@PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping(value = "/remove", produces = "application/json")
	public boolean deleteProduct(@RequestParam int id) throws ProductNotFoundException {
		return service.removeProduct(id);
	}
	
	@GetMapping(value = "/category/{category}", produces = "application/json")
	public List<Product> getProductByCategory(@PathVariable String category) {
		return service.fetchProductByCategory(category);
	}
	
	@GetMapping(value = "/priceRange", produces = "application/json")
	public List<Product> getProductByPriceRange(@RequestParam double min, @RequestParam double max) {
		return service.fetchProductByPriceRange(min, max);
	}
	
	@GetMapping(value = "/sortPrice", produces = "application/json")
	public List<Product> sortProductByPrice() {
		return service.sortProductByPriceRange();
	}
}
