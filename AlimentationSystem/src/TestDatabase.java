import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import it21505.java.project.DAO.UserDAO;
import it21505.java.project.Models.User;

public class TestDatabase {
		
	public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost/alimentationdb?useSSL=false";
        String user = "root";
        String pass = "toor";

        try {
                System.out.println("Connecting to database: " + jdbcUrl);
                Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
                System.out.println("Connection success");

        } catch (Exception e) {
                e.printStackTrace();
        }
       
}
	
	
}
