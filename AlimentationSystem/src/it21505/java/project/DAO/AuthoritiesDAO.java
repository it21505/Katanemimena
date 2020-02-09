package it21505.java.project.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it21505.java.project.Models.Authorities;
import it21505.java.project.Models.User;

@Repository
public class AuthoritiesDAO implements DAO<Authorities> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Authorities> getAll() {
		List<Authorities> authorities = null;
		try {
		Session session = sessionFactory.getCurrentSession();
		authorities = session.createQuery("from Authorities", Authorities.class).getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return authorities;	
	}

	@Override
	public Authorities getById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Authorities authorities) {
		Session session = sessionFactory.getCurrentSession();
		session.save(authorities);	
	}

	@Override
	public void update(Authorities authorities) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("update Authorities set username = '"+authorities.getUser().getUsername() +"' , authority = '" + authorities.getAuthority() +"' where id = '" + authorities.getId() + "'");
		q.executeUpdate();
	}

	@Override
	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete Authorities where username =:username ");
		q.setParameter("username", id);
		q.executeUpdate();
	}

}
