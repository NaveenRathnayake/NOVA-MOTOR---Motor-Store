package Model;

import java.sql.*;

import javax.swing.JOptionPane;

import Admin.Admin_Home;
import Begin.Login;
import Sales_Manager.Add_Sales;
import Sales_Person.Sales_Person_Home;
import Util.db_connection;

public class Login_Model {

	int loginID;
	String username;
	String password;
	
		// connection object
		db_connection dbConnection = new db_connection();
		
		
		// constructor
		public Login_Model() {
		}

		public Login_Model(int loginID, String username, String password) {
			super();
			this.loginID = loginID;
			this.username = username;
			this.password = password;	
		}
		
		// method to check login details
		public String checkloginDetails(String username, String password) {
			String output = "";

			String uname = username;
			String pw = password;
			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "select * from `login` where User_Name = ? and Password = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				pst.setString(1, uname);
				pst.setString(2, pw);				
				pst.execute();
				ResultSet rs = pst.executeQuery();
				
				//verify login details from table
				if (rs.next()) {
					//set methods to load Home pages what belongs to the user type
						if(username.equals("Admin")) {
							Admin_Home adhome = new Admin_Home();
							adhome.setVisible(true);							
						}
						else if(username.equals("Sales Manager")) {
							Add_Sales addsales = new Add_Sales();
							addsales.setVisible(true);						
						}
						else if(username.equals("Sales Person")) {
							Sales_Person_Home sphome = new Sales_Person_Home();
							sphome.setVisible(true);							
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid Login Details");
							Login login = new Login();
							login.setVisible(true);
						}
						conn.close();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Details");
					Login login = new Login();
					login.setVisible(true);
				}
				
				
			} catch (Exception e) {				
				e.printStackTrace();
			}

			return output;
		}
	
}
