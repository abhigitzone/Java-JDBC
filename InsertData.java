package com.java.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.*;

//Insert data into database..
public class InsertData {

	public static void main(String[] args) throws Exception {
		String urlString = "jdbc:mysql://localhost:3306/employeedb";
		String username = "devUser";
		String password = "Ganesha@mysql123";
		//We can write data manually..
		//String queryString = "INSERT INTO employee VALUES(6,\"Prashant Thankur\",3211,450000,\"Programmer Analyst\")";
		
		//Else we can take input from user and insert into database.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter ID : ");
		int id = scanner.nextInt();
		
		System.out.println("Enter Name : ");
		String name = scanner.next();
		
		System.out.println("Enter empId : ");
		int empId = scanner.nextInt();
		
		System.out.println("Enter salary : ");
		long salary = scanner.nextInt();
		
		System.out.println("Enter Designation : ");
		String designation = scanner.next();
		
		String queryString = "INSERT INTO employee VALUES(" + id + ",'" + name + "','"+ empId +"','"+ salary +"','"+ designation +"')";
		//This is a very tedious process, instead we can use PreparedStatement. Check DemoJdbcInsertDynamically
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(urlString, username, password);
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(queryString);
		
		System.out.println(count + " row/s affected");

		statement.close();
		connection.close();
		scanner.close();

	}

}
