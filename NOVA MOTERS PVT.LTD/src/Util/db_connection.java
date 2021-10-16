package Util;

import java.sql.*;

public class db_connection {
	
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nova_moters", "root", "");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return con;
	}

}
