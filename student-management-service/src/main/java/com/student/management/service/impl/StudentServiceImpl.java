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

/*student service implementation class
*/

@Service
public class StudentServiceImpl implements StudentService {

	private static final String DEFAULT_START_AGE = "3";
	private static final String DEFAULT_END_AGE = "65";

	@Autowired
	private StudentDao studentDao;

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public List<Student> getStudents(String startAge, String endAge) {

		List<Student> studentList = (List<Student>) studentDao.getStudents();

		if (StringUtils.isBlank(startAge) && StringUtils.isBlank(endAge)) {
			return studentList;

		} else if (StringUtils.isBlank(startAge) && StringUtils.isNotBlank(endAge)) {
			startAge = DEFAULT_START_AGE;

		} else if (StringUtils.isNotBlank(startAge) && StringUtils.isBlank(endAge)) {
			endAge = DEFAULT_END_AGE;
		}

		int firstAge = Integer.parseInt(startAge);
		int lastAge = Integer.parseInt(endAge);
		List<Student> studentListByAge = new ArrayList<>();

		if (firstAge > 0 && lastAge >= firstAge) {
			/*
			 * for(Student student : studentList) { if(student.getAge()>=firstAge &&
			 * student.getAge()<=lastAge) { studentListByAge.add(student); } }
			 */

			studentListByAge = studentList.stream().filter(
					studentLstByAge -> (studentLstByAge.getAge() >= firstAge && studentLstByAge.getAge() <= lastAge))
					.collect(Collectors.toList());
		}
		return studentListByAge;

	}

	@Override
	public Student getStudent(int id) {
		Student student = studentDao.getStudent(id);

		return student;
	}

	@Override
	public List<Address> getAddressByStudentId(int id) {

		Student student = this.getStudent(id);
		List<Address> studentAddressList = student.getAddress();
		/*
		 * if(studentAddressList == null || studentAddressList.size()==0) { throw new
		 * DataNotFoundException("Address doesnot exist for Student Id!"+id); }
		 */
		return studentAddressList;
	}

}