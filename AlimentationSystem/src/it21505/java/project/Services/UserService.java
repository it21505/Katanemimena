
package it21505.java.project.Services;

import it21505.java.project.Models.Authorities;
import it21505.java.project.Models.User;
import java.util.List;

public interface UserService {

	public List<User> getAll();
	
	User getUserById(String id);
	
	int getIdByUsername(String username);
		
    void saveUser(User user);
     
    void updateUser(User user);  
     
    void deleteUser(String id);
       
    void saveRole(Authorities authority);
    
    void updateRole(Authorities authority);
    
    void deleteRole(String id);
    
}
