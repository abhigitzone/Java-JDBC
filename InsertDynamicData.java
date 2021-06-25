package com.java.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//Inserting the data into database and reading it..
public class InsertDynamicData {

	public static void main(String[] args) throws Exception {
		String urlString = "jdbc:mysql://localhost:3306/employeedb";
		String username = "devUser";
		String password = "Ganesha@mysql123";

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

		String queryString = "INSERT INTO employee VALUES(?,?,?,?,?)"; // ? is written because we don't have any data yet.

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(urlString, username, password);
		PreparedStatement statement = connection.prepareStatement(queryString);
		// writing into Database..
		statement.setInt(1, id);
		statement.setString(2, name);
		statement.setInt(3, empId);
		statement.setLong(4, salary);
		statement.setString(5, designation);

		int count = statement.executeUpdate();

		System.out.println(count + " row/s affected");
		//Reading from the database..
		Statement st = connection.createStatement();
		String qurey = "SELECT * FROM employee";
		ResultSet rs = st.executeQuery(qurey);
		System.out.println("Reading from database...");
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getInt(4) + " : "
					+ rs.getString(5));
		}

		statement.close();
		connection.close();
		scanner.close();

	}

}
