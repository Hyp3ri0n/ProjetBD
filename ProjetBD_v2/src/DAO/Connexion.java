package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import debug.Debug;

public class Connexion {
	
	public final static String configurationFile = "src/DAO/DB.properties";
	private static Connection connexion = null;
	
	public static Connection connexion() throws IOException, ClassNotFoundException, SQLException
	{
		if(connexion != null) return connexion;
		
		try
		{
			DBAccesProperties dbAccess = new DBAccesProperties(configurationFile);
			connexion = DriverManager.getConnection(dbAccess.getDBUrl(), dbAccess.getUsername(), dbAccess.getPassword());
		}
		catch(Exception e)
		{
			Debug.display("Exception : " + e.getMessage());
			e.printStackTrace();
		}
		
		return connexion;
	}
	
//	public static ResultSet execute(String query) throws Exception
//	{
//		Statement stmt = connexion().createStatement();
//		return stmt.executeQuery(query);
//	}
}
