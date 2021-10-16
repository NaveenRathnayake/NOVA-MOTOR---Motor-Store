package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.db_connection;

public class Register_Customer_Model {

	int customerID;
	String firstname;
	String surname;
	String gender;
	String dob;
	String email;
	String contactno;
	String address;
	String nicno;
	
		// connection object
		db_connection dbConnection = new db_connection();
		
		
		// constructor
		public Register_Customer_Model() {
		}
		
		public Register_Customer_Model(int customerID, String firstname, String surname, String gender, String dob,
				String email, String contactno, String address, String nicno) {
			super();
			this.customerID = customerID;
			this.firstname = firstname;
			this.surname = surname;
			this.gender = gender;
			this.dob = dob;
			this.email = email;
			this.contactno = contactno;
			this.address = address;
			this.nicno = nicno;
		}

		
		// method to insert customer details
		public String insertcustomerDetails(String firstname, String surname, String gender, String dob,
				String email, String contactno, String address, String nicno) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "insert into customer_detail values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setInt(1, 0);
				pst.setString(2, firstname);
				pst.setString(3, surname);
				pst.setString(4, gender);
				pst.setString(5, dob);
				pst.setString(6, email);
				pst.setString(7, contactno);
				pst.setString(8, address);
				pst.setString(9,nicno);				
				pst.execute();
				conn.close();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to update customer details
		public String updatecustomerDetails( String search, String firstname, String surname, String gender, String dob,
				String email, String contactno, String address, String nicno) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "update customer_detail set `First_name` = ?, `Surname` = ?, `Gender` = ?, `D.O.B.` = ?, `Email` = ?, `Contact_No` = ?, `Address` = ?, `NIC_No` = ? where `Customer_ID` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);
				pst.setString(2, firstname);
				pst.setString(3, surname);
				pst.setString(4, gender);
				pst.setString(5, dob);
				pst.setString(6, email);
				pst.setString(7, contactno);
				pst.setString(8, address);
				pst.setString(9,nicno);					
				pst.execute();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to delete customer details
		public String deletecustomerDetails( String search) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "delete from  customer_detail where `Customer_ID` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);			
				pst.execute();
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return output;
		}
		
		
}
