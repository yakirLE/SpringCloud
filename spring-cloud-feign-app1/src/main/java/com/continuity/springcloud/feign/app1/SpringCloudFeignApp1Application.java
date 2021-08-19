package com.continuity.springcloud.feign.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.continuity.springcloud.feign.app1.proxy")
public class SpringCloudFeignApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApp1Application.class, args);
	}

}
