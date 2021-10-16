package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.db_connection;

public class Employee_Model {

	int employeeID;
	String firstname;
	String surename;
	String gender;
	String dob;
	String email;
	String contactno;
	String address;
	String designation;
	String basicsalary;
	String nic;
	
	
		// connection object
		db_connection dbConnection = new db_connection();
		
		
		// constructor
		public Employee_Model() {
		}

		public Employee_Model(int employeeID, String firstname, String surename, String gender, String dob,
				String email, String contactno, String address, String designation, String basicsalary, String nic) {
			super();
			this.employeeID = employeeID;
			this.firstname = firstname;
			this.surename = surename;
			this.gender = gender;
			this.dob = dob;
			this.email = email;
			this.contactno = contactno;
			this.address = address;
			this.designation = designation;
			this.basicsalary = basicsalary;
			this.nic = nic;
		}

		// method to insert employee details
		public String insertemployeeDetails(String firstname, String surename, String gender, String dob,
				String email, String contactno, String address, String designation, String basicsalary, String nic) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "insert into employee values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setInt(1, 0);
				pst.setString(2, firstname);
				pst.setString(3, surename);
				pst.setString(4, gender);
				pst.setString(5, dob);
				pst.setString(6, email);
				pst.setString(7, contactno);
				pst.setString(8, address);
				pst.setString(9, designation);
				pst.setString(10, basicsalary);
				pst.setString(11, nic);				
				pst.execute();
				conn.close();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to update employee details
		public String updateemployeeDetails( String search, String firstname, String surename, String gender, String dob,
				String email, String contactno, String address, String designation, String basicsalary, String nic) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "update employee set `First_Name` = ?, `Surename` = ?, `Gender` = ?,`D.O.B` = ?,`Email` = ?, `Contact_NO` = ?, `Address` = ?, `Designation` = ?,`Basic_Salary` = ?, `Nic` = ? where Employee_ID = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);
				pst.setString(2, firstname);
				pst.setString(3, surename);
				pst.setString(4, gender);
				pst.setString(5, dob);
				pst.setString(6, email);
				pst.setString(7, contactno);
				pst.setString(8, address);
				pst.setString(9, designation);
				pst.setString(10, basicsalary);
				pst.setString(11, nic);				
				pst.execute();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to delete employee details
		public String deleteemployeeDetails( String search) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "delete from  employee where `Employee_ID` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);			
				pst.execute();
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return output;
		}
		
		
}
