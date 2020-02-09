package it21505.java.project.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it21505.java.project.DAO.DataDAO;
import it21505.java.project.DAO.StudentDAO;
import it21505.java.project.Models.Application;
import it21505.java.project.Models.Data;
import it21505.java.project.Models.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
    private StudentDAO studentDAO;
	
	@Autowired 
	private DataDAO dataDAO;

	@Override
	@Transactional
	public List<Student> getAll() {
		List<Student> students = studentDAO.getAll();
		return students;
	}
	
	@Override
	public List<Student> getAllUncheckedStudents(List<Student> students) {
		List<Student> unchecked = new ArrayList<Student>();
		for(Student s : students) {			
			if(!s.isChecked()) {
				unchecked.add(s);
			}
		}
		return unchecked;
	}
	
	@Override
	public List<Student> getAllSendStudents(List<Student> students) {
		List<Student> send = new ArrayList<Student>();
		for(Student s : students) {			
			if(s.isSend()) {
				send.add(s);
			}
		}
		return send;
	}
	
	@Override
	public List<Student> getAllApprovedStudents(List<Student> students) {
		List<Student> approved = new ArrayList<Student>();
		for(Student s : students) {			
			if(s.isApproved()) {
				approved.add(s);
			}
		}
		return approved;
	}
	
	@Override
	public List<Student> getsAllUncheckedApplications(List<Student> students) {
		List<Student> unchecked = new ArrayList<Student>();
		for(Student s : students) {			
			if(!s.isApproved() && s.isSend()) {
				unchecked.add(s);
			}
		}
		return unchecked;
	}
	
	@Override
	@Transactional
	public Student getStudentById(String id) {
		Student student = studentDAO.getById(id);
		return student;
	}
	
	@Override
	@Transactional
	public Student getStudentByUsername(String username) {
		List<Student> students = studentDAO.getAll();
		for(Student s : students) {
			if(s.getLogin().getUsername().equals(username)) {
				return s;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDAO.save(student);
	}

	@Override
	@Transactional
	public void update(Student student) {
		studentDAO.update(student);
		
	}

	@Override
	@Transactional
	public void delete(String id) {
		studentDAO.delete(id);
		
	}

	@Override
	@Transactional
	public Data getData() {
		Data data = dataDAO.getById("1");
		return data;
	}

	@Override
	@Transactional
	public void updateData(Data data) {
		dataDAO.update(data);
		System.out.println("Data updated");
	}

	@Override
	@Transactional
	public boolean checkIfStudentExists(String username) {
		List<Student> students = studentDAO.getAll();
		for(Student s:students) {
			if(s.getLogin().getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	


}
