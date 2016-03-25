package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Prestataire;
import metier.Salle;

public class DAOPrestataire {

	public static ArrayList<Prestataire> getPrestataires() throws Exception
	{
		String query = "SELECT * FROM prestataire;";
		ArrayList<Prestataire> prestataires = new ArrayList<Prestataire>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Prestataire prestataire = new Prestataire();
				ArrayList<Salle> salles = DAOSalle.getSallesByPrestataire(rs.getInt(0));
				prestataire.setId(rs.getInt(0));
				prestataire.setNom(rs.getString(0));
				prestataire.setAdresse(rs.getString(1));
				prestataire.setType(rs.getInt(2));
				prestataire.setSalles(salles);
				
				prestataires.add(prestataire);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getPrestataires");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return prestataires;
	}
	
	public static Prestataire getPrestataire(int idPrestataire) throws Exception
	{
		String query = "SELECT * FROM prestataire WHERE pre_num = " + idPrestataire;
		Prestataire prestataire = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				prestataire = new Prestataire();
				ArrayList<Salle> salles = DAOSalle.getSallesByPrestataire(rs.getInt(1));
				prestataire.setId(rs.getInt(1));
				prestataire.setNom(rs.getString(2));
				prestataire.setAdresse(rs.getString(3));
				prestataire.setType(rs.getInt(4));
				prestataire.setSalles(salles);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getPrestataire(idPrestataire)\nidPrestataire = " + idPrestataire);
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return prestataire;
	}
}
