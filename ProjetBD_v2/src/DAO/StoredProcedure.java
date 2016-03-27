package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class StoredProcedure {

	public static void ajouterSeminaire(java.sql.Date sem_date, String sem_theme, int ani_num, double sem_tarif, int sem_nbPlaces, int sem_salle, int sem_type) throws Exception
	{
		boolean ajoutOK = false;
		
		String insertQuery =  "INSERT INTO seminaire(sem_num, sem_theme, sem_nbplaces, sem_date, sem_type, sem_salle, sem_tarif, sem_animateur) "
							+ "VALUES(SEQ_SEMINAIRE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connexion = null;
		PreparedStatement pStmt = null;
		CallableStatement c3 = null;
		ResultSet rs = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			pStmt = connexion.prepareStatement(insertQuery);
			
			pStmt.setString(1, sem_theme);
			pStmt.setInt(2, sem_nbPlaces);
			pStmt.setDate(3, sem_date);
			pStmt.setInt(4, sem_type);
			pStmt.setInt(5, sem_salle);
			pStmt.setDouble(6, sem_tarif);
			pStmt.setInt(7, ani_num);
			
			c3 = connexion.prepareCall("CALL constraintmanager.contrainte_3(?)");
			c3.setDate(1, sem_date);
			c3.execute();
			
			if(pStmt.executeUpdate() == 1)
				ajoutOK = true;
			
		}
		catch(Exception e)
		{
			if(connexion != null) connexion.close();
			System.out.println(e);
			ajoutOK = false;
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(pStmt != null) pStmt.close();
			if(rs != null) rs.close();
		}
		
		if(!ajoutOK) throw new SQLException("Erreur lors de l'ajout du seminaire");
	}
	
	/**
	 * Permet d'inscrire au séminaire une personne
	 * en vérifiant les contraintes de dates
	 * @param sem_num Numéro du séminaire
	 * @param idPersonne Identifiant de la personne à inscrire
	 * @throws Exception
	 */
	public static void inscription(int sem_num, int idPersonne) throws Exception
	{
		boolean ajoutOK = false;
		
		SimpleDateFormat format = new SimpleDateFormat("dd mm yyyy", Locale.FRANCE);
		
		Date today = new Date();
		Date closeInscription = null;
		Date openInscription = null;
		
		String strDate = format.format(today);
		
		String semDateQuery = "SELECT ADD_MONTHS(sem_date, -1), sem_date - 7 FROM seminaire WHERE sem_num = " + sem_num;
		String insertInsQuery = "INSERT INTO inscription VALUES (TO_DATE(" + strDate + ", 'dd-mm-yyyy'), " + idPersonne + ", " + sem_num + ");";
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			
			rs = stmt.executeQuery(semDateQuery);
			if(rs.next())
			{
				openInscription = rs.getDate(1);
				closeInscription = rs.getDate(2);
			}
			rs.close();
			
			if(today.after(openInscription) && today.before(closeInscription))
			{
				if(stmt.executeUpdate(insertInsQuery) == 1);
					ajoutOK = true;
			}

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
		
		if(!ajoutOK) throw new SQLException("Erreur lors de l'inscription\nDate d'inscription entre le " + openInscription + " et le " + closeInscription);
	}
	
	/**
	 * Permet d'annuler l'inscription d'une personne pour un séminaire
	 * en verifiant que le seminaire n'est pas encore confirmé
	 * @param sem_num Numéro du séminaire
	 * @param idPersonne Identifiant de la personne souhaitant se désinscrire
	 * @throws Exception
	 */
	public static void annulerInscription(int sem_num, int idPersonne) throws Exception
	{
		boolean canDel = true;
		
		String confQuery = "SELECT sem_confirmation FROM seminaire WHERE sem_num = " + sem_num;
		String deleteQuery = "DELETE FROM inscription WHERE ins_personne = " + idPersonne + " AND ins_seminaire = " + sem_num;
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			
			rs = stmt.executeQuery(confQuery);
			if(rs.next())
				canDel = rs.getInt(1) == 0 ? true : false;
			rs.close();
			
			if(canDel)
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
			if(rs != null) rs.close();
		}
		
		if(!canDel) throw new SQLException("Impossible d'annuler l'inscription");
	}
	
	/**
	 * Permet de valider un séminaire en respectant la contrainte du nombre de participants
	 * @param sem_num Numéro du séminaire à valider
	 * @throws Exception
	 */
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
	
	/**
	 * Permet de visualiser les séminaires de la semaine
	 * @param date Date définissant la semaine à visualiser
	 * @throws Exception
	 */
	public static void viewWeek(Date date) throws Exception
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
		
		Calendar calendrier = Calendar.getInstance();
		calendrier.setTime(date);
		
		Calendar monday = (Calendar) calendrier.clone();
		monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		Calendar sunday = (Calendar) calendrier.clone();
		sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		
		String strMonday = format.format(monday.getTime());
		String strSunday = format.format(sunday.getTime());
		
		String semQuery = "SELECT sem_num, sem_date, tps_libelle, sem_theme, sem_nbplaces, sem_tarif, "
						+ "CONCAT(ani_nom, CONCAT(' ', ani_prenom) as animateur, pre_nom, NVL(nbInscrit, 0) as nbInscrit "
						+ "FROM seminaire "
						+ "JOIN salle ON sem_salle = sal_num "
						+ "JOIN prestataire ON sal_prestataire = pre_num "
						+ "JOIN animateur ON sem_animateur = ani_num "
						+ "JOIN typeseminaire ON sem_type = tps_num "
						+ "LEFT JOIN (SELECT ins_seminaire, COUNT(*) AS nbInscrit FROM inscription GROUP BY ins_seminaire) ON sem_num = ins_seminaire "
						+ "WHERE sem_date BETWEEN TO_DATE('" + strMonday + "', 'dd-mm-yyyy') AND TO_DATE('" + strSunday + "', 'dd-mm-yyyy');";
		
		Connection connexion = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:default:connection");
			stmt = connexion.createStatement();
			rs = stmt.executeQuery(semQuery);
			
			System.out.println("Semaine du " + strMonday + " au " + strSunday + "\n");
			System.out.println("Date\t\tTheme\t\tNb. Places\tTarif\tAnimateur\tPrestataire\tNb. Inscrit\n");
			while(rs.next())
			{
				System.out.print(rs.getDate(2) + " - " + rs.getString(3) + "\t" + rs.getString(4));
				System.out.print("\t" + rs.getInt(5) + "\t" + rs.getDouble(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getInt(9));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connexion != null) connexion.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
	}
}
