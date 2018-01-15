package com.student.management.persistence.dao;

import java.util.List;

import com.student.management.persistence.dto.Student;

public interface StudentDao {

	public void addStudent(Student student) ;

	public List<Student> getStudents();
	
	public Student getStudent(int id);
}
