package it21505.java.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application {

	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CITYOFUNIVERSITY")
	private String cityOfUniversity;
	
	@Column(name = "NUMBEROFSTUDYINGBROTHERS")
	private String numberOfStudyingBrothers;
	
	@Column(name = "INCOME")
	private String income;
	
	@Column(name = "FAMILYINCOME")
	private String familyIncome;
	
	@OneToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;
	
	public Application() {
		
	}

	public Application( String cityOfUniversity, String numberOfStudyingBrothers, String income,
			String familyIncome,Student student) {
		super();
		this.cityOfUniversity = cityOfUniversity;
		this.numberOfStudyingBrothers = numberOfStudyingBrothers;
		this.income = income;
		this.familyIncome = familyIncome;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityOfUniversity() {
		return cityOfUniversity;
	}

	public void setCityOfUniversity(String cityOfUniversity) {
		this.cityOfUniversity = cityOfUniversity;
	}

	public String getNumberOfStudyingBrothers() {
		return numberOfStudyingBrothers;
	}

	public void setNumberOfStudyingBrothers(String numberOfStudyingBrothers) {
		this.numberOfStudyingBrothers = numberOfStudyingBrothers;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(String familyIncome) {
		this.familyIncome = familyIncome;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
