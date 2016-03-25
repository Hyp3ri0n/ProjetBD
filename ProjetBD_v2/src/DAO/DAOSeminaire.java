package DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

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
		String query = "SELECT * FROM seminaire;";
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
				Animateur animateur = DAOAnimateur.getAnimateur(rs.getInt(4));
				ArrayList<Inscription> inscriptions = DAOInscription.getInscriptionsBySeminaire(rs.getInt(0));
				ArrayList<Pause> pauses = DAOPause.getPausesBySeminaire(rs.getInt(0));
				Salle salle = DAOSalle.getSalle(rs.getInt(4));
				s.setId(rs.getInt(0));
				s.setTheme(rs.getString(0));
				s.setNbPlaces(rs.getInt(1));
				s.setDate(rs.getDate(2));
				s.setType(TypeSeminaire.getEnum(rs.getInt(0)));
				s.setAnimateur(animateur);
				s.setInscriptions(inscriptions);
				s.setSalle(salle);
				s.setPauses(pauses);
				
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
				seminaire.setId(rs.getInt(1));
				seminaire.setTheme(rs.getString(2));
				seminaire.setNbPlaces(rs.getInt(3));
				seminaire.setDate(rs.getDate(4));
				seminaire.setType(TypeSeminaire.getEnum(rs.getInt(6)));
				seminaire.setAnimateur(animateur);
				seminaire.setInscriptions(inscriptions);
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
	
	public static boolean test(int id) throws Exception
	{
		boolean ok = false;
		
		try
		{
			CallableStatement cs = Connexion.connexion().prepareCall("? = CALL constraintmanager.contrainte_1(?)");
			cs.setInt(2, id);
			cs.registerOutParameter(1, Types.BOOLEAN);
			ResultSet rs = cs.executeQuery();
			ok = rs.getBoolean(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ok = false;
		}
		
		return ok;
	}
}
