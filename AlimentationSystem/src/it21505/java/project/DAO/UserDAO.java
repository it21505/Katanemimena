package it21505.java.project.DAO;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it21505.java.project.Models.User;

@Repository
public class UserDAO implements DAO<User> {

	
	/*     OLD WAY
	 *  SessionFactory factory = new Configuration().
	 * configure("hibernate.cfg.xml") .addAnnotatedClass(User.class)
	 * .buildSessionFactory();
	 */
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<User> getAll() {
		List<User> users = null;
		try {
		Session session = sessionFactory.getCurrentSession();
		users = session.createQuery("from User", User.class).getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return users;

	}

	@Override
	@Transactional
	public List<User> getUsersByRole(String role) {
		List<User> users = null;
		try {
		Session session = sessionFactory.getCurrentSession();		
		 users = session.createQuery("from User u where u.=" + "'" + role + "'").getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	@Override
	@Transactional
	public User getUserById(String id) {
		User user=null;
		try {
		Session session = sessionFactory.getCurrentSession();
		user = session.get(User.class, id);	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	@Transactional
	public void save(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(user);		
		System.out.println("Saved");
		
		
	}

	@Override
	@Transactional
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		System.out.println("Updated");
			

	}

	@Override
	@Transactional
	public void delete(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);
		System.out.println("Deleted");
		

	}
	
	/*
	 * public boolean check(User user) {
	 * 
	 * List<User> dbusers = userDAO.getAll(); if(!dbusers.isEmpty()) { for(User u :
	 * dbusers) { if(u.getUsername().equals(user.getUsername()) ||
	 * u.getEmail().equals(user.getEmail())) { return false; } } } return true; }
	 */

}
