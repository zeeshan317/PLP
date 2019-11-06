package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicesLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesLabApplication.class, args);
	}

}
