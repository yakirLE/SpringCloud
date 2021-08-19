package com.continuity.springcloud.feign.app1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.continuity.springcloud.feign.app1.proxy.App2ServiceProxy;

@RestController
public class GenericController {

	private static final Logger logger = LoggerFactory.getLogger(GenericController.class);
	
	@Autowired
	private App2ServiceProxy app2Proxy;
	
	@GetMapping("/hello")
	public String message() {
		return "Hello from Feign-App1";
	}
	
	@GetMapping("/exec")
	public ResponseEntity<HttpStatus> exec() {
		logger.info("Demo execution in Feign-App1");
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/test-message")
	public String execApp1Message() {
		String msg = app2Proxy.hello();
		logger.info("Executed App2 Message: " + msg);
		
		return msg;
	}
	
	@GetMapping("/test-action")
	public ResponseEntity<HttpStatus> execApp1Action() {
		ResponseEntity<HttpStatus> status = app2Proxy.doSomething();
		logger.info("Executed App2 Action: " + status);
		
		return status;
	}
}
