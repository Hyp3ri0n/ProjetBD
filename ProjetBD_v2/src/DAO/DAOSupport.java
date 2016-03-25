package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Support;

public class DAOSupport {

	public static Support getSupport(int id) throws Exception
	{
		String query = "SELECT * FROM support WHERE sup_num = " + id;
		Support support = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				support = new Support();
				support.setId(rs.getInt(0));
				support.setNom(rs.getString(0));
				support.setFichier(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getSupport(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return support;
	}
	
	public static ArrayList<Support> getSupportsByPrestation(int idPrestation) throws Exception
	{
		String query = "SELECT * FROM support WHERE sup_num = " + idPrestation; //TODO a modifier
		ArrayList<Support> supports = new ArrayList<Support>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Support support = new Support();
				support.setId(rs.getInt(0));
				support.setNom(rs.getString(0));
				support.setFichier(rs.getString(1));
				
				supports.add(support);
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getSupportsByActivite(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return supports;
	}
}
