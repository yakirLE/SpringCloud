package com.continuity.springcloud.feign.app2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.continuity.springcloud.feign.app2.proxy.App1ServiceProxy;

@RestController
public class GenericController {

	private static final Logger logger = LoggerFactory.getLogger(GenericController.class);
	
	@Autowired
	private App1ServiceProxy app1Proxy;
	
	@GetMapping("/hello")
	public String message() {
		return "Hello from Feign-App2";
	}
	
	@GetMapping("/act")
	public ResponseEntity<HttpStatus> exec() {
		logger.info("Demo execution in Feign-App2");
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/test-message")
	public String execApp1Message() {
		String msg = app1Proxy.helloMessage();
		logger.info("Executed App1 Message: " + msg);
		
		return msg;
	}
	
	@GetMapping("/test-action")
	public ResponseEntity<HttpStatus> execApp1Action() {
		ResponseEntity<HttpStatus> status = app1Proxy.exec();
		logger.info("Executed App1 Action: " + status);
		
		return status;
	}
}
