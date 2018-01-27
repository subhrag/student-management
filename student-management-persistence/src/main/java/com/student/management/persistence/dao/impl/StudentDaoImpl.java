package com.student.management.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.student.management.persistence.dao.StudentDao;
import com.student.management.persistence.dto.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	
	
	@Override
	public void addStudent(Student student) {
		
		entityManager.persist(student);
	}



	@Override
	public List<Student> getStudents() {
		Query query = entityManager.createQuery("select s from Student s");
		
		return (List<Student>)query.getResultList();
		
	}



	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}



	
}
