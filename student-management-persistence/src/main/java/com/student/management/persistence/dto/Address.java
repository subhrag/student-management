package com.student.management.persistence.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/* student address entity class*/

@Entity
@Table(name = "STUDENT_ADDRESS")
public class Address  {

	@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator="identity")
    @GenericGenerator(name="identity", strategy="identity")
	@Column(name = "ID", nullable = false)
	private int addressId;
	
	/*@Column(name = "ADDRESS_ID")
	private int addressId;*/
	
	@Column(name = "ADDRESS_LINE1")
	private String addrs1;
	@Column(name = "ADDRESS_LINE2")
	private String addrs2;
	/*@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	*/
	/*@ManyToOne
	@JoinColumn(name = "STUDENT_ID", nullable = false )
	private Student student;*/
	
	public Address() {}
	
	
	/*public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}*/
	public int getaddressId() {
		return addressId;
	}
	public void setaddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddrs1() {
		return addrs1;
	}
	public void setAddrs1(String addrs1) {
		this.addrs1 = addrs1;
	}
	public String getAddrs2() {
		return addrs2;
	}
	public void setAddrs2(String addrs2) {
		this.addrs2 = addrs2;
	}
	/*public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	private String pincode;
	*/
	
}
