package com.cg.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

@RestController
@RequestMapping(value = "/product")
public class ProductFrontController {

	@Autowired
	RestTemplate resttemplate;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Product addProduct(@RequestBody Product product) {
		Product p = resttemplate.postForObject("http://localhost:8880/product/add/", product , Product.class);
		return p;
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
		try {
			return resttemplate.getForObject("http://localhost:8880/product/" + id , Product.class);
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for id: " + id);
		}
	}
	
	@GetMapping(value = "getAll", produces = "application/json")
	public List<Product> getAllProduct() {
		return Arrays.asList(resttemplate.getForObject("http://localhost:8880/product/getAll", Product[].class));
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public Product updateProduct(@RequestBody Product product) {
		resttemplate.put("http://localhost:8880/product/update/", product , Product.class);
		return product;
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean removeProduct(@RequestParam int id) throws ProductNotFoundException {
		try {
			resttemplate.delete("http://localhost:8880/product/remove/" + "?id=" + id, Boolean.class);
			return true;
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for id: " + id);
		}
	}
	
	@GetMapping(value = "pricerange", produces = "application/json")
	public List<Product> getProductByPriceRange(@RequestParam double min, @RequestParam double max) throws ProductNotFoundException {
		try {
			return Arrays.asList(resttemplate.getForObject("http://localhost:8880/product/pricerange/" + "?min=" + min + "&max=" + max, Product[].class));
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for the price range.");
		}
	}
	
	@GetMapping(value = "name/{name}", produces = "application/json")
	public Product getProductByName(@PathVariable String name) throws ProductNotFoundException {
		try {
			return resttemplate.getForObject("http://localhost:8880/product/name/" + name, Product.class);
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for name: " + name);
		}
	}
	
	@GetMapping(value = "quantity/{quantity}", produces = "application/json")
	public List<Product> getProductByQuantity(@PathVariable int quantity) throws ProductNotFoundException {
		try {
			return Arrays.asList(resttemplate.getForObject("http://localhost:8880/product/quantity/" + quantity, Product[].class));
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for quantity: " + quantity);
		}
	}
}

