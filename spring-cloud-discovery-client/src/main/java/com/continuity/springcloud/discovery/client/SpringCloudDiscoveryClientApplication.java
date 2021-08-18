package com.continuity.springcloud.discovery.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudDiscoveryClientApplication {

	@Autowired
	private EurekaClient client;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDiscoveryClientApplication.class, args);
	}

	@RequestMapping("/")
	public String callService() {
		RestTemplate restTempalte = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("discovery-service", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response = restTempalte.exchange(baseUrl, HttpMethod.GET, null, String.class);
		
		return response.getBody();
	}
}
