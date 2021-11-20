package dao;

import java.sql.*;



public class Connect {

    public  Connection c = null;
	
	 public Connect() throws ClassNotFoundException {

	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	
//	            c= DriverManager.getConnection("jdbc:mysql://localhost/technologydb" , "root" , "");
	            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/technologydb" , "root" , "");


	        } catch (SQLException e) {
	            e.getNextException();
	            
	        }

}
	
	
	
}