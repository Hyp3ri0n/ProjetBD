package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;

import metier.Pause.TypePause;
import metier.Seminaire;
import metier.Seminaire.TypeSeminaire;

public class ConstraintManager {

	/**
	 * Contrainte sur l'ajout d'activités
	 * @param sem_num identifiant du séminaire
	 * @throws SQLException
	 */
	public static boolean contrainte_1(int sem_num) throws SQLException
	{
		boolean contrainteOK = true;
		
		String countQuery = "SELECT COUNT(*) FROM activite WHERE act_seminaire = " + sem_num;
		String seminaireQuery = "SELECT sem_type FROM seminaire WHERE sem_num = " + sem_num;
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int nbActivite = 0;
		int typeSeminaire = 0;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			
			rs = stmt.executeQuery(seminaireQuery);
			if(rs.next())
				typeSeminaire = rs.getInt(1);
			rs.close();
			
			rs = stmt.executeQuery(countQuery);
			if(rs.next())
				nbActivite = rs.getInt(1);
			rs.close();
			if(nbActivite >= TypeSeminaire.getEnum(typeSeminaire).getNbActivite())
				contrainteOK = false;

		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
			
			contrainteOK = false;
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		
		if(!contrainteOK) throw new SQLException("Impossible d'ajouter l'activite");
		return contrainteOK;
	}
	

	/**
	 * Contrainte sur l'ajout de pauses
	 * @param idSeminaire
	 * @param typePause
	 * @param idPrestataire
	 * @return
	 * @throws Exception
	 */
	public static boolean contrainte_2(int sem_num, int tpa_num, int pre_num) throws SQLException
	{
		boolean contrainteOK = true;
		
		String seminaireQuery = "SELECT sem_type FROM seminaire WHERE sem_num = " + sem_num;
		String nbPauseQuery = "SELECT COUNT(*) FROM reserverPause WHERE res_seminaire = " + sem_num + " AND res_type = " + tpa_num; // 0 -> possible ajout
		String prestaQuery =  "SELECT sal_prestataire FROM salle sal INNER JOIN seminaire sem ON sal.sal_num = sem.sem_salle WHERE sem.sem_num = " + sem_num;
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int idPresta = 0;
		int typeSeminaire = 0;
		int nbPause = 0;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			connexion.setAutoCommit(true);
			stmt = connexion.createStatement();

			rs = stmt.executeQuery(seminaireQuery);
			if(rs.next())
				typeSeminaire = rs.getInt(1);
			rs.close();
			if(!Seminaire.pauseCompatible(TypeSeminaire.getEnum(typeSeminaire), TypePause.getEnum(tpa_num)))
				contrainteOK = false;
			
			rs = stmt.executeQuery(prestaQuery);
			if(rs.next())
				idPresta = rs.getInt(1);
			rs.close();
			if(idPresta != pre_num)
				contrainteOK = false;
			
			rs = stmt.executeQuery(nbPauseQuery);
			if(rs.next())
				nbPause = rs.getInt(1);
			rs.close();
			if(nbPause != 0)
				contrainteOK = false;
		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
			
			contrainteOK = false;
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		if(!contrainteOK) throw new SQLException("Impossible d'ajouter la pause");
		return contrainteOK;
	}
	
	
	/**
	 * Contrainte sur l'ajout de séminaire
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public static boolean contrainte_3(Date sem_date) throws SQLException
	{
		boolean contrainteOK = true;
		String message;
		
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.FRANCE);
		String strDate = format.format(sem_date);
		
		String countQuery = "SELECT COUNT(*) FROM seminaire WHERE sem_date = TO_DATE('" + strDate + "', 'dd-mm-yyyy');";
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			connexion.setAutoCommit(true);
			stmt = connexion.createStatement();
			
			rs = stmt.executeQuery(countQuery);
			if(rs.next())
			{
				message = "";
				if(rs.getInt(1) == 3)
				{
					contrainteOK = false;
					message = "Impossible d'ajouter le seminaire";
				}
			}
			rs.close();
		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
			message = "Erreur requete";
			contrainteOK = false;
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		if(!contrainteOK) throw new SQLException("Impossible d'ajouter le seminaire");
		return contrainteOK;
	}
}
