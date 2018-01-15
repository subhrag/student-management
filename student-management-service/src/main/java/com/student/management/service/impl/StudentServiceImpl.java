package com.student.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.persistence.dao.StudentDao;
import com.student.management.persistence.dto.Address;
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

	@Override
	public List<Student> getStudents() {
		return (List<Student>)stdDao.getStudents();
	}

	@Override
	public Student getStudent(int id)  {
		Student student = stdDao.getStudent(id);
		
		return student;
	}

	@Override
	public List<Address> getAddressByStudentId(int id)  {
		
		Student student = this.getStudent(id);
		 List<Address> studentAddressList = student.getStudentAddress();
		 /*if(studentAddressList == null || studentAddressList.size()==0) {
			 throw new DataNotFoundException("Address doesnot exist for Student Id!"+id);
		 }*/
		return studentAddressList;
	}
	
	
}