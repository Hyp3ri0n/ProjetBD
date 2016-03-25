package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Prestataire;
import metier.Salle;

public class DAOSalle {

	public static Salle getSalle(int idSalle) throws Exception
	{
		String query = "SELECT * FROM salle WHERE sal_num = " + idSalle;
		Salle salle = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				salle = new Salle();
				salle.setId(rs.getInt(1));
				salle.setNom(rs.getObject(2).toString());
				salle.setNbPlaces(rs.getInt(3));
				salle.setTarif(rs.getDouble(4));
				Prestataire presta = DAOPrestataire.getPrestataire(rs.getInt(5));
				salle.setPrestataire(presta);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getSalle(id)\nid = " + idSalle);
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return salle;
	}
	
	public static ArrayList<Salle> getSallesByPrestataire(int idPrestataire) throws Exception
	{
		String query = "SELECT * FROM salle WHERE sal_prestataire = " + idPrestataire;
		ArrayList<Salle> salles = new ArrayList<Salle>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Salle salle = new Salle();
				salle = new Salle();
				salle.setId(rs.getInt(1));
				salle.setNom(rs.getString(2));
				salle.setNbPlaces(rs.getInt(3));
				salle.setTarif(rs.getDouble(4));
				
				salles.add(salle);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getSallesByPrestataire(idPrestataire)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return salles;
	}
}
