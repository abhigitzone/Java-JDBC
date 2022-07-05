package com.java.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTable {

	public static void main(String[] args) throws Exception {
		String urlString = "jdbc:mysql://localhost:3306/employeedb";
		String username = "devUser";
		String password = "";

		Scanner scanner = new Scanner(System.in);

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(urlString, username, password);

		String query = "SELECT * FROM employee";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query); // For reading the database.
		System.out.println("Reading from database...");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getInt(4)
					+ " : " + rs.getString(5));
		}
		/**
		 * A Statement object can have only one active ResultSet, so when we execute
		 * rowResult = st.executeQuery(rowSelected) in line 40, the first ResultSet (rs) gets closed.
		 * And will throw error. To solve this, I have made new statement object for each ResultSet..
		 */
		System.out.println();
		System.out.println("Which row you want to update? :  ");
		int id = scanner.nextInt();
		String rowSelected = "SELECT * FROM employee WHERE id='" + id + "'";
		Statement st2 = connection.createStatement(); //Create this object as many times as you run multiple queries.
		ResultSet rowResult = st2.executeQuery(rowSelected); // Reading 1 row from database..
		while (rowResult.next()) {
			int idRow = rowResult.getInt("id");
			String nameRow = rowResult.getString("name");
			int empId = rowResult.getInt("empId");
			int salary = rowResult.getInt("salary");
			String designation = rowResult.getString("designation");
			System.out.println();
			System.out.println("Fetched Row :  "+" ID : " + idRow + " | " + " Name : " + nameRow + " | " + " Emp ID : " + empId + " | "
					+ " Salary : " + salary + " | " + " Designation : " + designation);
			System.out.println();
			System.out.println("What you want to update? : ");
			System.out.println();
			System.out.println("Press 1 : Name");
			System.out.println("Press 2 : Emp Id");
			System.out.println("Press 3 : Salary");
			System.out.println("Press 4 : Designation");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter new Name : ");
				String updateName = scanner.next();
				String updateQuery = "UPDATE employee SET name = '" + updateName + "' where id = '" + idRow + "'";
				Statement st3 = connection.createStatement();
				st3.executeUpdate(updateQuery); // For manipulating the database.
				System.out.println("Name " + updateName + " has been updated..");
				st3.close();
			}
				break;
			case 2: {
				System.out.println("Enter new Employee Id : ");
				int updateEmp = scanner.nextInt();
				String updateQuery = "UPDATE employee SET emp_id = '" + updateEmp + "' where id = '" + idRow + "'";
				Statement st4 = connection.createStatement();
				st4.executeUpdate(updateQuery); // For manipulating the database.
				System.out.println("Employee ID: " + updateEmp + " has been updated..");
				st4.close();

			}
				break;
			case 3: {
				System.out.println("Enter new Salary : ");
				int updateSalary = scanner.nextInt();
				String updateQuery = "UPDATE employee SET salary = '" + updateSalary + "' where id = '" + idRow + "'";
				Statement st5 = connection.createStatement();
				st5.executeUpdate(updateQuery); // For manipulating the database.
				System.out.println("Salary: " + updateSalary + " has been updated..");
				st5.close();

			}
				break;
			case 4: {
				System.out.println("Enter new Designation : ");
				String updateDesignation = scanner.next();
				String updateQuery = "UPDATE employee SET designation = '" + updateDesignation + "' where id = '"
						+ idRow + "'";
				Statement st6 = connection.createStatement();
				st6.executeUpdate(updateQuery); // For manipulating the database.
				System.out.println("Designation : " + updateDesignation + " has been updated..");
				st6.close();

			}
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);

			}

		}

		scanner.close();
		st.close();
		st2.close();
		connection.close();

	}

}
