package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import debug.Debug;
import metier.Personne;

public class DAOPersonne {

	public static Personne getPersonne(int id) throws Exception
	{
		String query = "SELECT * FROM personne WHERE per_num = " + id;
		Personne personne = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				personne = new Personne();
				personne.setId(rs.getInt(1));
				personne.setNom(rs.getString(2));
				personne.setPrenom(rs.getString(3));
				personne.setAdresse(rs.getString(4));
				personne.setTelephone(rs.getString(5));
				personne.setMail(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getPersonne(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return personne;
	}
}
