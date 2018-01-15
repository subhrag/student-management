package com.student.management.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.student.management.persistence.dao.AddressDao;
import com.student.management.persistence.dto.Address;
import com.student.management.persistence.dto.Student;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	@Override
	public void addAddress(Address address) {

		entityManager.persist(address);
		
	}
	
	
	/*@Override
	public Address getAddressByStudentId(int id) {
		Student student = entityManager.find(Student.class, id);
		List<Integer> studentAddressIdList = student.getStudentAddress().getAddressId(); 
		
		Address address = new Address();
				
		for (Integer studentAddressId : studentAddressIdList) {
				entityManager.find(Address.class, studentAddressId);	
		}
		return address;
	}*/

}
