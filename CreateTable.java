package com.java.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {

	public static void main(String[] args) throws Exception {
		String urlString = "jdbc:mysql://localhost:3306/employeedb";
		String username = "devUser";
		String password = "Ganesha@mysql123";
		
		Scanner scanner = new Scanner(System.in);

		String create = "CREATE TABLE expenditure(id int PRIMARY KEY auto_increment, name text, item_name text, total_item int, spend float)";
		//String drop = "DROP TABLE expenditure";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(urlString, username, password);
		Statement statement = connection.createStatement();
		statement.executeUpdate(create);
		
		//Insert some value into database.
		String insertData = "INSERT INTO expenditure values(1,'Abhishek', 'CornFlakes',1, 120.00)";
		Statement statement2 = connection.createStatement();
		statement2.executeUpdate(insertData);
		System.out.println("Data added successfully");
		
		String readData= "SELECT * FROM expenditure";
		Statement statement3 = connection.createStatement();
		ResultSet rs = statement3.executeQuery(readData);
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getString(3) + " : " + rs.getInt(4) + " : "
					+ rs.getFloat(5));
		}
		
		scanner.close();
		connection.close();
		statement.close();
	}

}
