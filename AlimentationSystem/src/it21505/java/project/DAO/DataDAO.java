package it21505.java.project.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it21505.java.project.Models.Data;
import it21505.java.project.Models.Student;
@Repository

public class DataDAO implements DAO<Data> {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Data> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Data getById(String id) {
		Session session = sessionFactory.getCurrentSession();
		int intId = Integer.parseInt(id);
		Data data = session.get(Data.class, intId);
		return data;
	}

	@Override
	public void save(Data data) {
		Session session = sessionFactory.getCurrentSession();
		session.save(data);	
		
	}

	@Override
	public void update(Data data) {
		Session session = sessionFactory.getCurrentSession();
		session.update(data);	
		
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Data data = session.get(Data.class, id);
		session.delete(data);
		
	}

}
