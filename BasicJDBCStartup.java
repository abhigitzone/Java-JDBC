package com.java.jdbc1;

import java.sql.*;

/*
 * 1. import ----> java.sql
 * 2. load and register the driver --> com.mysql.jdbc.Driver
 * 3. Create Connection ---> Connection
 * 4. Create a statement ---> Statement
 * 5. Execute a query -->
 * 6. Process the results -->
 * 7. Close
 * Notes: MySQL index starts with 1.
 */
//Fetching one value from database
public class BasicJDBCStartup {

	public static void main(String[] args) throws Exception{
		String urlString="jdbc:mysql://localhost:3306/employeedb";
		String username="devUser";
		String password="Ganesha@mysql123";
		String queryString = "select designation from employee where id=1"; //fetching one value from database.
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.
				getConnection(urlString,username,password);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(queryString);
		
		 rs.next(); //Use to set the pointer to first row. 
		 String name = rs.getString("designation"); 
		 System.out.println(name);
		 
		statement.close();
		connection.close();

	}

}
