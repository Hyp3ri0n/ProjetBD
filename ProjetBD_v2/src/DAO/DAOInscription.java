package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Inscription;
import metier.Personne;

public class DAOInscription {

	public static ArrayList<Inscription> getInscriptionsBySeminaire(int idSeminaire) throws Exception
	{
		String query = "SELECT * FROM inscription WHERE ins_seminaire = " + idSeminaire;
		ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Inscription ins = new Inscription();
				Personne p = DAOPersonne.getPersonne(rs.getInt(0));
				ins.setPersonne(p);
				ins.setDate(rs.getDate(1));
				
				inscriptions.add(ins);
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getInscriptionsBySeminaire(idSeminaire)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		return inscriptions;
	}
}
