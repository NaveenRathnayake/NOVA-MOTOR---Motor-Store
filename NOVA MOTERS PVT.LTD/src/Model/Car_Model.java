package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Util.db_connection;

public class Car_Model {

	int carID;
	String carname;
	String model;
	String brand;
	String color;
	String condition;
	String transmission;
	String fuel;
	String mileage;
	String price;
	String search;
	
		// connection object
		db_connection dbConnection = new db_connection();
			
		// constructor
		public Car_Model() {
				
		}
			
		public Car_Model(int carID, String carname, String model, String brand, String color, String condition,
			String transmission, String fuel, String mileage, String price) {
		super();
		this.carID = carID;
		this.carname = carname;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.condition = condition;
		this.transmission = transmission;
		this.fuel = fuel;
		this.mileage = mileage;
		this.price = price;
	}

		// method to insert login details
		public String insertcarDetails(String carname, String model, String brand, String color, String condition,
				String transmission, String fuel, String mileage, String price) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "insert into cars values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setInt(1, 0);
				pst.setString(2, carname);
				pst.setString(3, model);
				pst.setString(4, brand);
				pst.setString(5, color);
				pst.setString(6, condition);
				pst.setString(7, transmission);
				pst.setString(8, fuel);
				pst.setString(9, mileage);
				pst.setString(10, price);				
				pst.execute();
				conn.close();
				
			} catch (Exception e) {				
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to update login details
		public String updatecarDetails( String search, String carname, String model, String brand, String color, String condition,
				String transmission, String fuel, String mileage, String price) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "update cars set `Car_Name` = ?, `Car_Model` = ?, `Car_Brand` = ?, `Color` = ?, `Condition` = ?, `Transmission` = ?, `Fuel_Type` = ?, `Mileage` = ?, `Price` = ?  where `Car_ID` = ?";
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1, search);
				pst.setString(2, carname);
				pst.setString(3, model);
				pst.setString(4, brand);
				pst.setString(5, color);
				pst.setString(6, condition);
				pst.setString(7, transmission);
				pst.setString(8, fuel);
				pst.setString(9, mileage);
				pst.setString(10, price);				
				pst.execute();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return output;
		}
		
		
		// method to delete login details
		public String deletecarDetails( String search) {
			String output = "";

			try {
				Connection conn = db_connection.connect();
				if (conn == null) {
					System.out.println(" Error while Connecting to the database");
				}

				String query = "delete from cars where `Car_ID` = ?";
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
