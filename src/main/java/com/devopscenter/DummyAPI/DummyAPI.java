package com.devopscenter.DummyAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// This annotation instructs Spring to initialize its configuration - which is needed to start a
// new application
@SpringBootApplication
// Indicates that this class contains RESTful methods to handle incoming HTTP requests
@RestController
public class DummyAPI {
	private static int counter409 =0;
	// We can start our application by calling the run method with the primary class
	public static void main(String[] args) {
		SpringApplication.run(DummyAPI.class, args);
	}

	@GetMapping("/throw409") //method that throws a 409 error anytime it's called
	public void throw409() {
		counter409++;
		throw new ResponseStatusException(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/counter409") //prints out how many times the 409 error has been called
	public String counterFor409() {
		return "Called this many times: " + counter409;
	}
	

}
