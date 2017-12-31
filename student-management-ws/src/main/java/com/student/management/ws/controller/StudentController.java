package com.student.management.ws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@RequestMapping("/")
	public void getStudent() {
		System.out.println("Hello");
	}
}
