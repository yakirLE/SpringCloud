package com.continuity.springcloud.feign.app2.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign-app1")
public interface App1ServiceProxy {

	@GetMapping("/hello")
	String helloMessage();
	
	@GetMapping("/exec")
	ResponseEntity<HttpStatus> exec();
}
