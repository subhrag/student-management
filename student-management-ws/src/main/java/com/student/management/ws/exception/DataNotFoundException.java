package com.student.management.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND , reason ="ID not found ! ")
public class DataNotFoundException extends Exception {

	public DataNotFoundException(String msg) {
		super(msg);
	}

}
