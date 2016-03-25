package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Activite;
import metier.Prestation;

public class DAOActivite {

	public static Activite getActivite(int id) throws Exception
	{
		String query = "SELECT * FROM activite WHERE act_num = " + id;
		Activite activite = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				activite = new Activite();
				activite.setId(rs.getInt(0));
				activite.setLibelle(rs.getString(0));
				ArrayList<Prestation> prestations = null;
				activite.setPrestations(prestations);
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getActivite(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return activite;
	}
	
	public static ArrayList<Activite> getActivitesBySeminaire(int idSeminaire) throws Exception
	{
		String query = "SELECT * FROM activite WHERE act_num = " + idSeminaire; //TODO a modifier
		ArrayList<Activite> activites = new ArrayList<Activite>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Activite activite = new Activite();
				activite.setId(rs.getInt(0));
				activite.setLibelle(rs.getString(0));
				ArrayList<Prestation> prestations = null;
				activite.setPrestations(prestations);
				
				activites.add(activite);
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getActivitesBySeminaire(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return activites;
	}
}
