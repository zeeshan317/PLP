package com.cg.entity;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.cg.service.ProductService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DemoDataEntry {

	@Autowired
	private ProductService service;
	
	@EventListener
	public void onAppReady(ApplicationReadyEvent event) {
		if (service.fetchAllProduct().size() == 0) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				
				Product[] products = mapper.readValue(getClass().getClassLoader().getResource("product.json"), Product[].class);
				
				for(Product product: products) {
					service.saveProduct(product);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
