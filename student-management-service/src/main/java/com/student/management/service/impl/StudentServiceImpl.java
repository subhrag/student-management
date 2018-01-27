package com.student.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
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
	public List<Student> getStudents(String age1, String age2) {

		List<Student> studentList = (List<Student>) stdDao.getStudents();

		if (StringUtils.isNotBlank(age1) && StringUtils.isNotBlank(age2)) {
			int firstAge = Integer.parseInt(age1);
			int lastAge = Integer.parseInt(age2);
			List<Student> studentListByAge = new ArrayList<>();
			if (firstAge > 0 && lastAge >= firstAge) {
				/*
				 * for(Student student : studentList) { if(student.getAge()>=firstAge &&
				 * student.getAge()<=lastAge) { studentListByAge.add(student); } }
				 */

				studentListByAge = studentList.stream() // java 8 stream
						.filter(studentLstByAge -> (studentLstByAge.getAge() >= firstAge
								&& studentLstByAge.getAge() <= lastAge))
						.collect(Collectors.toList());
			}
			return studentListByAge;
		}

		return studentList;
	}

	@Override
	public Student getStudent(int id) {
		Student student = stdDao.getStudent(id);

		return student;
	}

	@Override
	public List<Address> getAddressByStudentId(int id) {

		Student student = this.getStudent(id);
		List<Address> studentAddressList = student.getStudentAddress();
		/*
		 * if(studentAddressList == null || studentAddressList.size()==0) { throw new
		 * DataNotFoundException("Address doesnot exist for Student Id!"+id); }
		 */
		return studentAddressList;
	}

}