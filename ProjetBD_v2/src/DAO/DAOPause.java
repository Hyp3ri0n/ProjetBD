package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Pause;
import metier.Prestataire;
import metier.Pause.TypePause;

public class DAOPause {

	public static ArrayList<Pause> getPausesBySeminaire(int idSeminaire) throws Exception
	{
		String query = "SELECT * FROM inscription WHERE ins_seminaire = " + idSeminaire;
		ArrayList<Pause> pauses = new ArrayList<Pause>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Pause p = new Pause();
				p.setTarif(rs.getDouble(0));
				p.setType(TypePause.getEnum(rs.getInt(0)));
				Prestataire pres = DAOPrestataire.getPrestataire(rs.getInt(0));
				p.setPrestataire(pres);
				
				pauses.add(p);
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getPausesBySeminaire(idSeminaire)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		return pauses;
	}
}
