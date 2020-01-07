package it21505.java.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "identification")
public class Identification {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "ADOPTIONDAY")
	private String adoptionDay;
	
	@Column(name = "ISSUINGAUTHORITY")
	private String issuingAuthority;
	
	@OneToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;
	
	public Identification() {
		
	}
	
	public Identification(String id, String adoptionDay, String issuingAuthority,Student student) {
		super();
		this.id = id;
		this.adoptionDay = adoptionDay;
		this.issuingAuthority = issuingAuthority;
		this.student = student;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdoptionDay() {
		return adoptionDay;
	}

	public void setAdoptionDay(String adoptionDay) {
		this.adoptionDay = adoptionDay;
	}

	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
