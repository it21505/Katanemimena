package it21505.java.project.Services;

import java.util.List;

import it21505.java.project.Models.Application;
import it21505.java.project.Models.Data;
import it21505.java.project.Models.Student;

public interface StudentService {

	public List<Student> getAll();
	
	public List<Student> getAllUncheckedStudents(List<Student> students);
	
	public List<Student> getAllSendStudents(List<Student> students);
	
	public List<Student> getAllApprovedStudents(List<Student> students);
	
	public List<Student> getsAllUncheckedApplications(List<Student> students);
	
	Student getStudentById(String id);
	
	Student getStudentByUsername(String username);
	
	Data getData();
	
	void updateData(Data data);
	
	void save(Student student);
    
    void update(Student student);
     
    void delete(String id);
    
    boolean checkIfStudentExists(String username);
	
}
