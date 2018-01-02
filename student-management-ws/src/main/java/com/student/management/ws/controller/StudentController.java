package com.student.management.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.persistence.dto.Student;
import com.student.management.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public void getStudent() {
		System.out.println("Hello");
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		System.out.println("Hello");
	}
}
