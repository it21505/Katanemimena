
package it21505.java.project.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it21505.java.project.DAO.AuthoritiesDAO;
import it21505.java.project.DAO.UserDAO;
import it21505.java.project.Models.Authorities;
import it21505.java.project.Models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDAO userDAO;
	
	@Autowired
    private AuthoritiesDAO authoritiesDAO;
	
	@Override
	@Transactional
	public List<User> getAll() {		
		List<User> users = userDAO.getAll();
		return users;
	}

	@Override
	@Transactional
	public User getUserById(String id) {
		User user = userDAO.getById(id);
		return user;
	}
	
	@Override
	@Transactional
	public int getIdByUsername(String username) {
		List<Authorities> authorities = authoritiesDAO.getAll();
		int id = 0 ;
		for(Authorities a : authorities) {
			if(a.getUser().getUsername().equals(username)) {
				id = a.getId();
			}
		}
		return id;
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.save(user);		
		System.out.println("User Saved");
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.update(user);	
		System.out.println("User Updated");
	}

	@Override
	@Transactional
	public void deleteUser(String id) {		
		userDAO.delete(id);
		System.out.println("User Deleted");
	}

	@Override
	@Transactional
	public void saveRole(Authorities authority) {
		authoritiesDAO.save(authority);
		System.out.println("Role Saved");
	}
	
	@Override
	@Transactional
	public void updateRole(Authorities authority) {
		authoritiesDAO.update(authority);
		System.out.println("Role Updated");
	}

	@Override
	@Transactional
	public void deleteRole(String id) {
		authoritiesDAO.delete(id);
		System.out.println("Role Deleted");
	}

	

	
	

}
