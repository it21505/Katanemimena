package it21505.java.project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SURNAME")
	private String surname;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FATHERNAME")
	private String fatherName;
	
	@Column(name = "MOTHERNAME")
	private String motherName;
	
	@Column(name = "UNIVERSITY")
	private String university;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "SEMESTER")
	private int semester;
	
	@Column(name = "RECORD")
	private long record;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
	@Column(name = "CHECKED")
	private boolean checked;
	
	@Column(name = "SCORE")
	private int score;
	
	@OneToOne(mappedBy = "student")
	private Identification identification;
	
	@OneToOne(mappedBy = "student")
	private Residence residence;
	
	@OneToOne(mappedBy = "student")
	private Application application;
	
	
	public Student() {
		
	}
	
	public Student(String name, String surname, String email, String fatherName, String motherName, String university,
			String department, int semester, long record, Identification identification, Residence residence,Application application,
			boolean active,boolean checked,int score) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.university = university;
		this.department = department;
		this.semester = semester;
		this.record = record;
		this.identification = identification;
		this.residence = residence;
		this.application = application;
		this.active = active;
		this.checked = checked;
		this.score = score;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public long getRecord() {
		return record;
	}

	public void setRecord(long record) {
		this.record = record;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int calculateScore() {
		int score=0;
		int familyIncome = Integer.parseInt(this.application.getFamilyIncome());
		int studentIncome = Integer.parseInt(this.application.getIncome());
		int numberOfStudyingBrother = Integer.parseInt(this.application.getNumberOfStudyingBrothers());
		String cityOfResidence = this.residence.getCity();
		String cityOfUniversity = this.application.getCityOfUniversity();
		if(familyIncome==0 && studentIncome==0) {
			score = 500;
		}else {
			if(familyIncome<10000) {
				score+=100;
			}else if(familyIncome<15000) {
				score+=30;
			}else {
				score+=0;
			}
			if(numberOfStudyingBrother>0) {
				score += 20*numberOfStudyingBrother;
			}
			if(!cityOfResidence.equals(cityOfUniversity)) {
				score+=50;
			}		
		}
		return score;
	}
	
}
