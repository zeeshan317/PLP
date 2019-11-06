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
		Product p = resttemplate.postForObject("http://product-service/product/add/", product , Product.class);
		return p;
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
		try {
			return resttemplate.getForObject("http://product-service/product/" + id , Product.class);
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for id: " + id);
		}
	}
	
	@GetMapping(value = "getAll", produces = "application/json")
	public List<Product> getAllProduct() {
		return Arrays.asList(resttemplate.getForObject("http://product-service/product/getAll", Product[].class));
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public Product updateProduct(@RequestBody Product product) {
		resttemplate.put("http://product-service/product/update/", product , Product.class);
		return product;
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean removeProduct(@RequestParam int id) throws ProductNotFoundException {
		try {
			resttemplate.delete("http://product-service/product/remove/" + "?id=" + id, Boolean.class);
			return true;
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for id: " + id);
		}
	}
	
	@GetMapping(value = "pricerange", produces = "application/json")
	public List<Product> getProductByPriceRange(@RequestParam double min, @RequestParam double max) throws ProductNotFoundException {
		try {
			return Arrays.asList(resttemplate.getForObject("http://product-service/product/pricerange/" + "?min=" + min + "&max=" + max, Product[].class));
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for the price range.");
		}
	}
	
	@GetMapping(value = "name/{name}", produces = "application/json")
	public Product getProductByName(@PathVariable String name) throws ProductNotFoundException {
		try {
			return resttemplate.getForObject("http://product-service/product/name/" + name, Product.class);
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for name: " + name);
		}
	}
	
	@GetMapping(value = "quantity/{quantity}", produces = "application/json")
	public List<Product> getProductByQuantity(@PathVariable int quantity) throws ProductNotFoundException {
		try {
			return Arrays.asList(resttemplate.getForObject("http://product-service/product/quantity/" + quantity, Product[].class));
		} catch (RestClientException e) {
			throw new ProductNotFoundException("No product found for quantity: " + quantity);
		}
	}
}

