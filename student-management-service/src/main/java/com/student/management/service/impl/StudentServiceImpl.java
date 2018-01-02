package com.student.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.persistence.dao.StudentDao;
import com.student.management.persistence.dto.Student;
import com.student.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentDao stdDao;

	@Override
	public void addStudent(Student student) {
		stdDao.addStudent(student);
		
	}
	
}