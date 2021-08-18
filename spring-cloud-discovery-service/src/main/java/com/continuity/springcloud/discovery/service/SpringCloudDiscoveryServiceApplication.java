package com.continuity.springcloud.discovery.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudDiscoveryServiceApplication {

	@Value("${service.instance.name}")
	private String instance;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDiscoveryServiceApplication.class, args);
	}
	
	@RequestMapping("/")
	public String message() {
		return "Hello from " + instance;
	}

}
