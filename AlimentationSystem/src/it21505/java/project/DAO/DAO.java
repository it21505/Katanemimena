package it21505.java.project.DAO;

import java.util.List;

public interface DAO<T> {

	List<T> getAll();
	
	T getById(String param);
		
    void save(T t);
     
    void update(T t);
     
    void delete(String param);
    
}
