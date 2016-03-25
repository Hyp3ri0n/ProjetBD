package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Conferencier;
import metier.Prestation;
import metier.Support;

public class DAOPrestation {

	public static ArrayList<Prestation> getPrestationsBySeminaire(int idSeminaire) throws Exception
	{
		String query = "SELECT * FROM activite WHERE act_num = " + idSeminaire; //TODO a modifier
		ArrayList<Prestation> prestations = new ArrayList<Prestation>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Prestation p = new Prestation();
				Conferencier conf = DAOConferencier.getConferencier(rs.getInt(0));
				ArrayList<Support> supports = DAOSupport.getSupportsByPrestation(rs.getInt(0));
				p.setId(rs.getInt(0));
				p.setConferencier(conf);
				p.setTarif(rs.getDouble(0));
				p.setSupports(supports);
								
				prestations.add(p);
			}
		}
		catch(Exception e)
		{
			Debug.display("Error : getPrestationsBySeminaire(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return prestations;
	}
}
