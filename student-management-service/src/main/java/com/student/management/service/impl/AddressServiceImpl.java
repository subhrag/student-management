package com.student.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.persistence.dao.AddressDao;
import com.student.management.persistence.dto.Address;
import com.student.management.service.AddressService;

@Service
public class AddressServiceImpl  implements AddressService {

	@Autowired
	public AddressDao addressDao;
	
	@Override
	public void addAddress(Address address) {

		addressDao.addAddress(address);
		
	}

	/*@Override
	public Address getAddressByStudentId(int id) {
		Address address = addrsDao.getAddressByStudentId(id);
		return address;
	}*/
	
}
