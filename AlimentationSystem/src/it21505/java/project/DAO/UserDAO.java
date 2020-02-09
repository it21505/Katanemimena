package it21505.java.project.DAO;

import java.util.List;

import javax.persistence.Query;
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

	/*
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

*/
	
	@Override
	public User getById(String id) {
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
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);			
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		String username = user.getUsername().split(" ")[0];
		String prevusername = user.getUsername().split(" ")[1];
		System.out.println("PREV :" + prevusername + " USER :" + username);
		
		Query query = session.createQuery("update User set username = :username , password = :password , enabled = :enabled , name = :name , surname = :surname , email = :email" +
				" where username = :prev");
		query.setParameter("username", username);
		query.setParameter("password", user.getPassword());
		query.setParameter("enabled", true);
		query.setParameter("name", user.getName());
		query.setParameter("surname", user.getSurname());
		query.setParameter("email", user.getEmail());
		query.setParameter("prev", prevusername);
		query.executeUpdate();
			
		//session.update(user);
	}

	@Override
	public void delete(String id) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		session.delete(user);
	}
	
	/*
	 * public boolean check(User user) {
	 * 
	 * List<User> dbusers = userDAO.getAll(); if(!dbusers.isEmpty()) { for(User u :
	 * dbusers) { if(u.getUsername().equals(user.getUsername()) ||
	 * u.getEmail().equals(user.getEmail())) { return false; } } } return true; }
	 */

}
