package com.java.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//Fetching the entire data from table
public class ReadTable {

	public static void main(String[] args) throws Exception {
		String urlString = "jdbc:mysql://localhost:3306/employeedb";
		String username = "devUser";
		String password = "";
		String queryString = "select * from employee"; // fetching the entire data from table

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(urlString, username, password);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(queryString);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getInt(4) + " : "
					+ rs.getString(5));
		}

		statement.close();
		connection.close();

	}

}
