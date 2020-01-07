package it21505.java.project.Models;

public class StudentApplication {

	private String name;
	private String surname;
	private String cityOfUniversity;
	private String cityOfResidence;
	private int numberOfStudyingBrothers;
	private long income;
	private long familyIncome;
	
	public StudentApplication() {
		
	}
	
	public StudentApplication(String name, String surname, String cityOfUniversity, String cityOfResidence,
			int numberOfStudyingBrothers, long income, long familyIncome) {
		super();
		this.name = name;
		this.surname = surname;
		this.cityOfUniversity = cityOfUniversity;
		this.cityOfResidence = cityOfResidence;
		this.numberOfStudyingBrothers = numberOfStudyingBrothers;
		this.income = income;
		this.familyIncome = familyIncome;
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

	public String getCityOfUniversity() {
		return cityOfUniversity;
	}

	public void setCityOfUniversity(String cityOfUniversity) {
		this.cityOfUniversity = cityOfUniversity;
	}

	public String getCityOfResidence() {
		return cityOfResidence;
	}

	public void setCityOfResidence(String cityOfResidence) {
		this.cityOfResidence = cityOfResidence;
	}

	public int getNumberOfStudyingBrothers() {
		return numberOfStudyingBrothers;
	}

	public void setNumberOfStudyingBrothers(int numberOfStudyingBrothers) {
		this.numberOfStudyingBrothers = numberOfStudyingBrothers;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public long getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(long familyIncome) {
		this.familyIncome = familyIncome;
	}
	
	
}
