package com.continuity.springcloud.config.client.app;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope // including startup initialized entities such as @Bean and @Value
public class SpringCloudConfigClientAppApplication {

	@Autowired
	private ConfigClientAppConfiguration properties;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientAppApplication.class, args);
	}

	@RequestMapping("/")
	public String printConfig() {
		StringJoiner sj = new StringJoiner(" || ");
		sj.add(properties.getProperty());
		sj.add(someOtherProperty);
		
		return sj.toString();
	}
}
