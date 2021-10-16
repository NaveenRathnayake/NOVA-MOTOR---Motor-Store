package Model;

import java.sql.*;
import Util.db_connection;

public class Add_Login_Model {
	
	int loginID;
	String username;
	String password;
	String search;
	
		// connection object
		db_connection dbConnection = new db_connection();
		
		
		// constructor
		public Add_Login_Model() {
		}

		public Add_Login_Model(int loginID, String username, String password) {
			super();
			this.loginID = loginID;
			this.username = username;
			this.password = password;	
		}
		
		// method to insert login details
		public String insertloginDetails(String username, String password) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "insert into login values (?, ?, ?)";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setInt(1, 0);
				pst.setString(2, username);
				pst.setString(3, password);				
				pst.execute();
				conn.close();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to update login details
		public String updateloginDetails( String search, String username, String password) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "update login set `User_Name` = ?, `Password` = ? where `ID` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);
				pst.setString(2, username);
				pst.setString(3, password);				
				pst.execute();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to delete login details
		public String deleteloginDetails( String search) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "delete from  login where `ID` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);			
				pst.execute();
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return output;
		}
		
		
}