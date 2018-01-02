package com.student.management.ws.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.management.ws.controller.StudentController;

@SpringBootApplication(scanBasePackages = "com.student.management")
public class SpringBootConfiguration {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootConfiguration.class, args);
	}
		

}
