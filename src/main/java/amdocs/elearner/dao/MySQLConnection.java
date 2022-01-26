package amdocs.elearner.dao;
import java.sql.*;

public class MySQLConnection {
	
	private static Connection con = null;

	private MySQLConnection() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(con == null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/e_learner";
			String username = "root";
			String password = "Ldrago1";
			con = DriverManager.getConnection(URL, username, password);
			return con;
		}
		else {
			return con;
		}
	}

}
