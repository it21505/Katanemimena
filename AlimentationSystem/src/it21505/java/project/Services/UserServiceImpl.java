/*
package it21505.java.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it21505.java.project.DAO.UserDAO;
import it21505.java.project.Models.User;

public class UserServiceImpl implements UserService {

	@Autowired
    private UserDAO userDAO;
	
	@Override
	public List<User> getAll() {		
		List<User> users = userDAO.getAll();
		return users;
	}

	@Override
	public List<User> getUsersByRole(String role) {
		List<User> users = userDAO.getUsersByRole(role);
		return users;
	}

	@Override
	public User getUserById(String id) {
		User user = userDAO.getUserById(id);
		return user;
	}

	@Override
	public void save(User user) {
		userDAO.save(user);	
	}

	@Override
	public void update(User user) {
		userDAO.update(user);		
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}
	
	

}*/
