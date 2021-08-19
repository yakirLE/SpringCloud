package com.continuity.springcloud.feign.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.continuity.springcloud.feign.app2.proxy")
public class SpringCloudFeignApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApp2Application.class, args);
	}

}
