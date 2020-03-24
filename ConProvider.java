package gagan;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Establishes connection to the database.
 *
 */
public class ConProvider {

	private static Connection con=null;
	
	public static Connection getConnection(){
	
	try{
		Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root"; //user name
        String password = "raziya"; // There is no password
        con = DriverManager.getConnection(url, username,password);
	}catch(Exception e){
		System.out.println(e);
		}
	return con;
    }
}
