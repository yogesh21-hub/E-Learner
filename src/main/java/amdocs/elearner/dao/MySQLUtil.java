package amdocs.elearner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class MySQLUtil {

	public static String insertQuery(String query) {
		try {
			Connection con = MySQLConnection.getConnection();
			Statement st = con.createStatement();
			
			int result = st.executeUpdate(query);
			if (result>=1)
			{
				System.out.println("Query inserted successfully!");
				return "success";
			}
			else {
				System.out.println("Error!");
				return "failure";
			}
		}
		catch (SQLIntegrityConstraintViolationException e)
		{
			System.out.println("Integrity constraint is violated: "+e.toString());
			return "integrityfailure";
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception occured: "+e.toString());
			return "sqlfailure";
		}
		catch(Exception e) {
			System.out.println("Exception occcured while inserting "
					+ "data:"+e.toString());
			return "exception";
		}
		
	}
	
	public static ResultSet fetchQuery(String query) {
		try {
			Connection con = MySQLConnection.getConnection();
			Statement st = con.createStatement();
			
			ResultSet result = st.executeQuery(query);
			return result;
		}
		catch(Exception e) {
			System.out.println("Exception occcured while fetching "
					+ "data:"+e.toString());
			return null;
		}
		
	}
}
