package com.continuity.springcloud.feign.app1.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign-app2")
public interface App2ServiceProxy {
	
	@GetMapping("/hello")
	String hello();
	
	@GetMapping("/act")
	ResponseEntity<HttpStatus> doSomething();

}
