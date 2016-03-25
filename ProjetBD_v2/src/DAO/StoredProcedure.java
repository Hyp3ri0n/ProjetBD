package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StoredProcedure {

	public static void ajouterSeminaire()
	{
		
	}
	
	public static void inscription(int sem_num, int idPersonne) throws Exception
	{
		//yyyy-mm-dd -> format.format(date);
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.FRANCE);
		String strDate = format.format(new Date());
		String strDateSem = "";
		
		String semQuery = "SELECT DATE_SUB(sem_date, INTERVAL 7 DAY) FROM seminaire WHERE sem_num = " + sem_num;
		String insertInsQuery = "INSERT INTO inscription VALUES (TO_DATE(" + strDate + ", 'dd-mm-yyyy'), " + idPersonne + ", " + sem_num + ");";
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			
			rs = stmt.executeQuery(semQuery);
			if(rs.next())
				strDateSem = format.format(rs.getDate(1));
			rs.close();
			
			if(strDate.equals(strDateSem))
				stmt.executeUpdate(insertInsQuery);

		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
		}
	}
	
	public static void annulerInscription(int sem_num, int idPersonne) throws Exception
	{
		String deleteQuery = "DELETE FROM inscription WHERE ins_personne = " + idPersonne + " AND ins_seminaire = " + sem_num;
		
		Connection connexion = null;
		Statement stmt = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			
			stmt.executeUpdate(deleteQuery);

		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
		}
	}
	
	public static void confirmerSeminaire(int sem_num) throws Exception
	{
		String nbInsQuery = "SELECT COUNT(*) FROM inscription WHERE ins_seminaire = " + sem_num;
		String nbPlaceQuery = "SELECT sem_nbplaces FROM seminaire WHERE sem_num = " + sem_num;
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int nbInscriptions = 0;
		int nbPlaces = 0;
		int conf = 0;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			
			rs = stmt.executeQuery(nbInsQuery);
			if(rs.next())
				nbInscriptions = rs.getInt(1);
			rs.close();
			
			rs = stmt.executeQuery(nbPlaceQuery);
			if(rs.next())
				nbPlaces = rs.getInt(1);
			rs.close();
			
			if(nbInscriptions >= (nbPlaces / 2))
				conf = 1;
			
			String uptSemQuery = "UPDATE seminaire SET sem_confirmation = " + conf + " WHERE sem_num = " + sem_num;
			stmt.executeUpdate(uptSemQuery);

		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
	}
	
	public static void viewWeek(java.sql.Date date)
	{
		
	}
}
