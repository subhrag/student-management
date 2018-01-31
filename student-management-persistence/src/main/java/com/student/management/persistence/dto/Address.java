package com.student.management.persistence.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT_ADDRESS")
public class Address  {

	@Id 
	@GeneratedValue(generator="identity")
    @GenericGenerator(name="identity", strategy="identity")
	@Column(name = "ID", nullable = false)
	private int aId;
	
<<<<<<< Updated upstream
	@Column(name = "ADDRESS_ID")
	private int addressId;
	
=======
>>>>>>> Stashed changes
	@Column(name = "ADDRESS_LINE1")
	private String addrs1;
	
	@Column(name = "ADDRESS_LINE2")
	private String addrs2;

	public Address() {}
<<<<<<< Updated upstream
	
	
	/*public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}*/
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
=======

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
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
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
=======
	
	
	
	
>>>>>>> Stashed changes
}
