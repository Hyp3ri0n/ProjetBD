package DAO;

import java.sql.ResultSet;
import java.sql.Statement;

import debug.Debug;
import metier.Conferencier;

public class DAOConferencier {

	public static Conferencier getConferencier(int id) throws Exception
	{
		String query = "SELECT * FROM activite WHERE act_num = " + id;
		Conferencier conf = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				conf = new Conferencier();
				conf.setId(rs.getInt(0));
				conf.setNom(rs.getString(0));
				conf.setPrenom(rs.getString(1));
				conf.setAdresse(rs.getString(2));
				conf.setTelephone(rs.getString(3));
				conf.setMail(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getConferencier(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return conf;
	}
}
