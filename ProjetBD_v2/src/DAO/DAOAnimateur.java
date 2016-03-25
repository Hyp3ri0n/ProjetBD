package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import debug.Debug;
import metier.Animateur;

public class DAOAnimateur {
	
	public static ArrayList<Animateur> getAnimateurs() throws Exception
	{
		String query = "SELECT * FROM animteur;";
		ArrayList<Animateur> animateurs = new ArrayList<Animateur>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Animateur anim = new Animateur();
				anim.setId(rs.getInt(0));
				anim.setNom(rs.getString(0));
				anim.setPrenom(rs.getString(1));
				anim.setAdresse(rs.getString(2));
				anim.setTelephone(rs.getString(3));
				anim.setMail(rs.getString(4));
				
				animateurs.add(anim);
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getAnimateurs");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return animateurs;
	}
	
	public static Animateur getAnimateur(int id) throws Exception
	{
		String query = "SELECT * FROM animateur WHERE ani_num = " + id;
		Animateur anim = null;

		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = Connexion.connexion().createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				anim = new Animateur();
				anim.setId(rs.getInt(0));
				anim.setNom(rs.getString(0));
				anim.setPrenom(rs.getString(1));
				anim.setAdresse(rs.getString(2));
				anim.setTelephone(rs.getString(3));
				anim.setMail(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			Debug.console("Error : getAnimateur(id)");
			e.printStackTrace();
		}
		finally
		{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		
		return anim;
	}
}
