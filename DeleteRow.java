package com.java.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRow {

	public static void main(String[] args) throws Exception {
		String urlString = "jdbc:mysql://localhost:3306/employeedb";
		String username = "devUser";
		String password = "";

		Scanner scanner = new Scanner(System.in);

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(urlString, username, password);

		String query = "SELECT * FROM employee";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query); //For reading the database.
		System.out.println("Reading from database...");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getInt(4)
					+ " : " + rs.getString(5));
		}
		System.out.println();
		System.out.println("Enter the Row you want to delete: ");
		int id = scanner.nextInt();

		String deleteQuery = "DELETE FROM employee WHERE id='" + id + "'";
		st.executeUpdate(deleteQuery); //For manipulating the database.
		System.out.println("Row "+ id +" has been deleted..");                         
	
		st.close();
		connection.close();
		scanner.close();

	}

}
