package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DBConnection {
	
	
	
	 public Connection Connect() {
	        try {
	            //Your database url string,ensure it is correct
	            String url = "jdbc:mysql://localhost:3306/registration1";
	            String user = "root";
	            String password = "1234";

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(url, user, password);
	           
	            System.out.println("Connected");
	            
	            
	            return conn;
	            
	            
	        

	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return null;
	    }

//

	

	
	
}
