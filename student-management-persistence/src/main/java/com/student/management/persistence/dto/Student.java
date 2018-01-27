package com.student.management.persistence.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENT")
public class Student  {

	@Id 
	@SequenceGenerator(name = "addrs_seq" , sequenceName = "std_addrs_seq" , allocationSize = 1 )
	@GeneratedValue(generator = "addrs_seq"  ,strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	private int sId;
	@Column(name = "FIRST_NAME")
	private String sFirstName;
	@Column(name = "LAST_NAME")
	private String sLastName;
	@Min(3) @Max(65)
	@Column(name = "STUDENT_AGE")
	private int age;
	/*@Column(name = "STD")
	private String sClass;
	@Column(name = "SCHOOL_NAME")
	private String sSchoolName;*/
	//@OneToMany( mappedBy ="student" ,cascade = CascadeType.ALL)	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Address> studentAddress;
	
	public Student() {}
	
	
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
/*	public String getsClass() {
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
	}*/
	
	public List<Address> getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(List<Address> studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
