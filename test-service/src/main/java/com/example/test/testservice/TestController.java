package com.example.test.testservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	
/*	@Autowired
	private GreetingService greetingService;*/
	 @GetMapping("/test")
	 @HystrixCommand(fallbackMethod="testFallback")
	 public String test() {
		 throw new RuntimeException();
	 }
	 
	 public String testFallback() {
		 return "fallback";
	 }
}
