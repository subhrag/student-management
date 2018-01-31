package com.student.management.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.student.management.persistence.dao.StudentDao;
import com.student.management.persistence.dto.Student;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for StudentServiceImpl.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@Mock
	private StudentDao studentDao;

	@InjectMocks
	private StudentServiceImpl studentService;

	@Before
	public void setUp() {
		when(studentDao.getStudents()).thenReturn(getAllStudents());
	}

	private List<Student> getAllStudents() {

		List<Student> studentList = new ArrayList<>();
		Student student1 = new Student();
		student1.setStudentId(1);
		student1.setFirstName("firstname1");
		student1.setLastName("lastname1");
		student1.setAge(20);

		Student student2 = new Student();
		student2.setStudentId(3);
		student2.setFirstName("firstname2");
		student2.setLastName("lastname2");
		student2.setAge(10);

		Student student3 = new Student();
		student3.setStudentId(4);
		student3.setFirstName("firstname3");
		student3.setLastName("lastname3");
		student3.setAge(50);

		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);

		return studentList;

	}

	@Test
	public void testGetStudents() {
		List<Student> studentList = studentService.getStudents("50", "60");

		assertNotNull("studentList shouldn't be null", studentList);
		assertEquals("Should have 1 student", 1, studentList.size());

		Student student = studentList.get(0);
		assertEquals("student id should match", 4, student.getStudentId());
		assertEquals("student first name should match", "firstname3", student.getFirstName());
		assertEquals("student last name should match", "lastname3", student.getLastName());
		assertEquals("student age should match", 50, student.getAge());

	}
	
	@Test
	public void testGetStudentsForEmptyStartInput() {
		List<Student> studentList = studentService.getStudents("", "30");
		assertNotNull("studentList shouldn't be null", studentList);
		assertEquals("Should have 2 students", 2, studentList.size());
		
		assertEquals("", "1,3", studentList.stream().map(student -> String.valueOf(student.getStudentId())).collect(Collectors.joining(",")));
		
		List<Student> studentList1 = studentList.stream().filter(student -> student.getStudentId() == 1).collect(Collectors.toList()); 
		assertNotNull("studentList shouldn't be null", studentList1);
		assertEquals("Should have 1 student", 1, studentList1.size());
		assertEquals("student id should match", 1, studentList1.get(0).getStudentId());
		assertEquals("student first name should match", "firstname1", studentList1.get(0).getFirstName());
		assertEquals("student last name should match", "lastname1", studentList1.get(0).getLastName());
		assertEquals("student age should match", 20, studentList1.get(0).getAge());
		
		List<Student> studentList2 = studentList.stream().filter(student -> student.getStudentId() == 3).collect(Collectors.toList()); 
		assertNotNull("studentList shouldn't be null", studentList2);
		assertEquals("Should have 1 student", 1, studentList2.size());
		assertEquals("student id should match", 3, studentList2.get(0).getStudentId());
		assertEquals("student first name should match", "firstname2", studentList2.get(0).getFirstName());
		assertEquals("student last name should match", "lastname2", studentList2.get(0).getLastName());
		assertEquals("student age should match", 10, studentList2.get(0).getAge());
	}
	
	
	@Test
	public void testGetStudentsForEmptyEndInput() {
		List<Student> studentList = studentService.getStudents("40", "");
		assertNotNull("studentList shouldn't be null", studentList);
		assertEquals("Should have 1 student", 1, studentList.size());
		
		Student student = studentList.get(0);
		assertEquals("student id should match", 4, student.getStudentId());
		assertEquals("student first name should match", "firstname3", student.getFirstName());
		assertEquals("student last name should match", "lastname3", student.getLastName());
		assertEquals("student age should match", 50, student.getAge());
	}

	@Test
	public void testGetStudentsForEmptyInput() {
		List<Student> studentList = studentService.getStudents("", "");
		assertNotNull("studentList shouldn't be null", studentList);
		assertEquals("Should have 3 students", 3, studentList.size());

		assertEquals("Student Ids should match", "1,3,4",
				studentList.stream().map(student -> String.valueOf(student.getStudentId())).collect(Collectors.joining(",")));
		
		List<Student> studentList1 = studentList.stream().filter(student -> student.getStudentId()==1).collect(Collectors.toList());
		assertNotNull("studentList should not be null", studentList1);
		assertEquals("should have 1 students", 1, studentList1.size());
		assertEquals("first name should match","firstname1", studentList1.get(0).getFirstName());
		assertEquals("last name should match","lastname1", studentList1.get(0).getLastName());
		assertEquals("age should match",20, studentList1.get(0).getAge());
		
		
		List<Student> studentList2 = studentList.stream().filter(student -> student.getStudentId()==3).collect(Collectors.toList());
		assertNotNull("studentList should not be null", studentList2);
		assertEquals("should have 1 students", 1, studentList2.size());
		assertEquals("first name should match","firstname2", studentList2.get(0).getFirstName());
		assertEquals("last name should match","lastname2", studentList2.get(0).getLastName());
		assertEquals("age should match",10, studentList2.get(0).getAge());
		
		List<Student> studentList3 = studentList.stream().filter(student -> student.getStudentId()==4).collect(Collectors.toList());
		assertNotNull("studentList should not be null", studentList3);
		assertEquals("should have 1 students", 1, studentList3.size());
		assertEquals("first name should match","firstname3", studentList3.get(0).getFirstName());
		assertEquals("last name should match","lastname3", studentList3.get(0).getLastName());
		assertEquals("age should match",50, studentList3.get(0).getAge());
	}
}
