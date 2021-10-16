package Model;

import java.sql.*;

import Util.db_connection;

public class Sales_Model {

	int SalesID;
	String cid;
	String vid;
	String tax;
	String pyMethod;
	String downPay;
	String month;
	String monthPay;
	String search;
	
		// connection object
		db_connection dbConnection = new db_connection();
		
		
		// constructor
		public Sales_Model() {
		}

		
		
		public Sales_Model(int salesID, String cid,String vid, String tax, String pyMethod, String downPay, String month,String monthPay) {
			super();
			SalesID = salesID;
			this.cid = cid;
			this.vid = vid;
			this.tax = tax;
			this.pyMethod = pyMethod;
			this.downPay = downPay;
			this.month = month;
			this.monthPay = monthPay;
		}


		// method to insert sales details
		public String insertsalesDetails(String cid,String vid, String tax, String pyMethod, String downPay, String month,String monthPay) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "insert into sales values (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setInt(1, 0);
				pst.setString(2, cid);
				pst.setString(3, vid);
				pst.setString(4, tax);
				pst.setString(5, pyMethod);
				pst.setString(6, downPay);
				pst.setString(7, month);
				pst.setString(8, monthPay);			
				pst.execute();
				conn.close();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to update sales details
		public String updatesalesDetails( String search, String cid,String vid, String tax, String pyMethod, String downPay, String month,String monthPay) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "update sales set `customer_id` = ?, `car_id` = ?, `tax` = ?, `payment_method` = ?, `down_pay` = ?, `terms_of_months` = ?, `intallement_per_month` = ? where sid = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);
				pst.setString(2, cid);
				pst.setString(3, vid);
				pst.setString(4, tax);
				pst.setString(5, pyMethod);
				pst.setString(6, downPay);
				pst.setString(7, month);
				pst.setString(8, monthPay);			
				pst.execute();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to delete sales details
		public String deletsalesDetails( String search) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "delete from sales where `sid` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);			
				pst.execute();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return output;
		}
}