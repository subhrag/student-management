package com.student.management.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
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

}
