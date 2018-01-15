package com.student.management.ws.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.persistence.dto.Address;
import com.student.management.persistence.dto.Student;
import com.student.management.service.StudentService;
import com.student.management.ws.exception.DataNotFoundException;



@RestController
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	

	@GetMapping(value = "/students")
	public List<Student> getStudents() {
		
		return studentService.getStudents();
		
	}
	
	@GetMapping(value = "/students/{id}")
	public Student getStudent(@PathVariable("id") int id) throws DataNotFoundException  {
		System.out.println(id);
		Student student = (Student) studentService.getStudent(id);
		if(student==null) {
			throw new DataNotFoundException("Student Id does not exist !"+id);
		}
		return student;
	}
	
	
	@RequestMapping(value = "/students/{id}/addresses", method = RequestMethod.GET)
	public List<Address> getAddressByStudentId(@PathVariable("id") int id) throws DataNotFoundException {
		
		List<Address> addressList = studentService.getAddressByStudentId(id);
		if(addressList==null){
			throw new DataNotFoundException("Address not found for id !"+id);
		}
		return addressList;
	}
	
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		System.out.println("Hello in add std");
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public String exceptionHandler(DataNotFoundException msg) {
		
		return msg.getMessage();
	}
}
