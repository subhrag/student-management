package com.student.management.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.persistence.dto.Address;
import com.student.management.service.AddressService;


@RestController
public class AddressController {
	
	
	@Autowired
	public AddressService addrsService;
	

	/*@RequestMapping(value = "/students/{id}/addresses", method = RequestMethod.GET)
	public void getAddressByStudentId(@PathVariable("id") int id) {
		
		addrsService.getAddressByStudentId(id);
		
		System.out.println("got address by "+id);
	}*/
	
	@PostMapping(value = "/addAddress",  produces = MediaType.APPLICATION_JSON_VALUE)
	public void addAddress(@RequestBody Address address) {
		addrsService.addAddress(address);
	}
}
