package com.student.management.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
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

	/**
	 * Save Student Entity
	 * 
	 * @param student is a student entity to be saved
	 */
	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
	}

	/**
	 * Retrieve all students
	 * @return returns all the students
	 */
	@Override
	public List<Student> getStudents() {
		Query query = entityManager.createQuery("select s from Student s");
		return (List<Student>) query.getResultList();
	}

	/**
	 * Retrieve Student Entity
	 * 
	 * @param id to retrieve student entity
	 * @return returns a student entity
	 */
	@Override
	public Student getStudent(int id) {
		return entityManager.find(Student.class, id);
	}

}
