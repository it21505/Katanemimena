import java.sql.Connection;
import java.sql.DriverManager;

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
