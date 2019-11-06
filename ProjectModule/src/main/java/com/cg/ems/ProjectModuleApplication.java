package com.cg.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.cg.ems")
//@EnableDiscoveryClient
public class ProjectModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectModuleApplication.class, args);
	}

}
