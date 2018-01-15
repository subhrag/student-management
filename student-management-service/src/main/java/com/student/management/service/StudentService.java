package com.student.management.service;

import java.util.List;

import com.student.management.persistence.dto.Address;
import com.student.management.persistence.dto.Student;

public interface StudentService {

	void addStudent(Student student);
	Student getStudent(int id) ;
	List<Address> getAddressByStudentId(int id) ;
	List<Student> getStudents();

}
