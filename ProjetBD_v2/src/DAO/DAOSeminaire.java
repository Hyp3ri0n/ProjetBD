package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import debug.Debug;
import metier.Animateur;
import metier.Inscription;
import metier.Pause;
import metier.Salle;
import metier.Seminaire;
import metier.Seminaire.TypeSeminaire;

public class DAOSeminaire {

	public static ArrayList<Seminaire> getSeminaires() throws Exception
	{
		String query = "SELECT * FROM seminaire";
		ArrayList<Seminaire> seminaires = new ArrayList<Seminaire>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Seminaire s = new Seminaire();
				Animateur animateur = DAOAnimateur.getAnimateur(rs.getInt(8));
				ArrayList<Inscription> inscriptions = DAOInscription.getInscriptionsBySeminaire(rs.getInt(1));
				ArrayList<Pause> pauses = DAOPause.getPausesBySeminaire(rs.getInt(1));
				Salle salle = DAOSalle.getSalle(rs.getInt(7));
				s.setId(rs.getInt(1));
				s.setTheme(rs.getString(2));
				s.setNbPlaces(rs.getInt(3));
				s.setDate(rs.getDate(4));
				s.setType(TypeSeminaire.getEnum(rs.getInt(6)));
				s.setAnimateur(animateur);
				s.setInscriptions(inscriptions);
				s.setSalle(salle);
				s.setPauses(pauses);
				s.setTarif(rs.getDouble(9));
				
				seminaires.add(s);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getSeminaires");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return seminaires;
	}
	
	public static Seminaire getSeminaire(int id) throws Exception
	{
		String query = "SELECT * FROM seminaire WHERE sem_num = " + id;
		Seminaire seminaire = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				seminaire = new Seminaire();	
				Animateur animateur = DAOAnimateur.getAnimateur(rs.getInt(8));
				ArrayList<Inscription> inscriptions = DAOInscription.getInscriptionsBySeminaire(rs.getInt(1));
				ArrayList<Pause> pauses = DAOPause.getPausesBySeminaire(rs.getInt(1));
				Salle salle = DAOSalle.getSalle(rs.getInt(7));
				seminaire.setId(rs.getInt(1));
				seminaire.setTheme(rs.getString(2));
				seminaire.setNbPlaces(rs.getInt(3));
				seminaire.setDate(rs.getDate(4));
				seminaire.setType(TypeSeminaire.getEnum(rs.getInt(6)));
				seminaire.setAnimateur(animateur);
				seminaire.setInscriptions(inscriptions);
				seminaire.setPauses(pauses);
				seminaire.setTarif(rs.getDouble(9));
				seminaire.setSalle(salle);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getSeminaire(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return seminaire;
	}
	
	public static void test(Date date) throws Exception
	{
		try
		{
			CallableStatement cs = Connexion.connexion().prepareCall("CALL constraintmanager.contrainte_3(?)");
			cs.setDate(1, new java.sql.Date(date.getTime()));
			cs.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
