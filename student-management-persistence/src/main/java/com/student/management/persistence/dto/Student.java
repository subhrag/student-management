package com.student.management.persistence.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name = "ID")
	private int sId;
	@Column(name = "FIRST_NAME")
	private String sFirstName;
	@Column(name = "LAST_NAME")
	private String sLastName;
	@Column(name = "STD")
	private String sClass;
	@Column(name = "SCHOOL_NAME")
	private String sSchoolName;
	//@Column(name = "ADDRESS")
	//private Address sAddress;
	
	public String getsFirstName() {
		return sFirstName;
	}
	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}
	public String getsLastName() {
		return sLastName;
	}
	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public  String getsSchoolName() {
		return sSchoolName;
	}
	public void setsSchoolName(String sSchoolName) {
		this.sSchoolName = sSchoolName;
	}
	
/*	public Address getsAddress() {
		return sAddress;
	}
	public void setsAddress(Address sAddress) {
		this.sAddress = sAddress;
	}*/
	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
	
}
