package it21505.java.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "residence")
public class Residence {
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "NUMBER")
	private String number;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "POSTALCODE")
	private String postalCode;
	
	@Id
	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@OneToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;
	
	public Residence() {
		
	}
	
	public Residence(String street, String number, String city, String postalCode, String telephone, String mobile,Student student) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.postalCode = postalCode;
		this.telephone = telephone;
		this.mobile = mobile;
		this.student = student;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
