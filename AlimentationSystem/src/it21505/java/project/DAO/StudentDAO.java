package it21505.java.project.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it21505.java.project.Models.Student;
import it21505.java.project.Models.User;

@Repository
public class StudentDAO implements DAO<Student> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Student> getAll() {
		List<Student> students = null;
		try {
		Session session = sessionFactory.getCurrentSession();
		students = session.createQuery("from Student", Student.class).getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return students;
	}

	@Override
	public List<Student> getUsersByRole(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Student getUserById(String id) {
		Student student=null;
		try {
		Session session = sessionFactory.getCurrentSession();
		int intId = Integer.parseInt(id);
		student = session.get(Student.class, intId);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return student;	
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String param) {
		// TODO Auto-generated method stub
		
	}

	
}
