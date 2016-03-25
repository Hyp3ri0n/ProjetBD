package ui;

import javax.swing.JFrame;

import debug.Debug;
import ui.frame.FUIMain;

public class MainApp {

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//Initialisation de la frame
		@SuppressWarnings("unused")
		JFrame mainFrame = new FUIMain();
		
		//Test		
		Debug.on();
		/*Personne p = new Personne(0, "Fernandes", "Aurélien", "aurel2405@gmail.com", "0600000000");
		Personne p1 = new Personne(1, "Ortiz", "Luc", "luc.ortiz9@gmail.com", "0600000000");
		Seminaire s = new Seminaire(0,"test",1,new Date(),TypeSeminaire.getEnum(1),new Animateur(2, "Martinier", "Alexis", "alexis.martinier@outlook.com", "0629451887"));
		s.ajouterParticipant(p);
		s.ajouterParticipant(p1);
		Pause pa = new Pause(new Prestataire(), 10.0, TypePause.PAUSE_PM);
		try {
			s.ajouterPause(pa);
		} catch (Exception e) {
			Debug.display(e);
			e.printStackTrace();
		}
		Debug.display(s.toString());*/
		
		Debug.display("bjr");
		//FinTest
	}	

}
