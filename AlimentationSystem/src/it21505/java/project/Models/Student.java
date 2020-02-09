package it21505.java.project.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@Column(name = "CHECKED")
	private boolean checked;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
	@Column(name = "SEND")
	private boolean send;
	
	@Column(name = "APPROVED")
	private boolean approved;
	
	@Column(name = "SCORE")
	private int score;
	
	@JsonIgnore
    @JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "student",fetch = FetchType.EAGER)
	private Identification identification;
	
	@JsonIgnore
    @JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "student",fetch = FetchType.EAGER)
	private Residence residence;
	
	@JsonIgnore
    @JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL , mappedBy = "student",fetch = FetchType.EAGER)
	private Application application;
	
	@JsonIgnore
    @JsonManagedReference
	@JoinColumn(name = "LOGIN_ID", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	public Student() {
		
	}
	
	public Student(String name, String surname, String email, String fatherName, String motherName, String university,
			String department, int semester, Identification identification, Residence residence,Application application,
			Login login ,boolean checked ,  boolean active, boolean send , boolean approved,int score) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.university = university;
		this.department = department;
		this.semester = semester;
		this.identification = identification;
		this.residence = residence;
		this.application = application;
		this.login = login;
		this.checked = checked;
		this.active = active;
		this.send = send;
		this.approved = approved;
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}	

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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
