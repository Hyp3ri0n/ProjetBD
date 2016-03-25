package ui.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.miginfocom.swing.MigLayout;
import ui.panel.PUIAccueil;
import ui.panel.PUIActivite;
import ui.panel.PUIInscription;
import ui.panel.PUIPersonnel;
import ui.panel.PUIPrestataire;
import ui.panel.PUISeminaire;

public class FUIMain extends JFrame {

	private static final long serialVersionUID = 1643282046810095466L;

	/**
	 * Create the frame.
	 */
	public FUIMain() {
		initialize();
		this.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Initialisation de la frame
		this.setBounds(100, 100, 1000, 700);
		this.setTitle("Projet BD - MARTINIER Alexis & FERNANDES Aurélien");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		//Instanciation du conteneur de tabs
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("test");
		this.getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		//Création tab Accueil
		JPanel panelAccueil = new PUIAccueil();
		tabbedPane.addTab("Accueil", null, panelAccueil, null);
		
		JPanel panelSeminaire = new PUISeminaire();
		tabbedPane.addTab("Séminaire", null, panelSeminaire, null);
		
		JPanel panelInscription = new PUIInscription();
		tabbedPane.addTab("Inscription", null, panelInscription, null);
		
		JPanel panelActivite = new PUIActivite();
		tabbedPane.addTab("Activité", null, panelActivite, null);
		
		JPanel panelPrestataire = new PUIPrestataire();
		tabbedPane.addTab("Prestataire", null, panelPrestataire, null);
		
		JPanel panelPersonnel = new PUIPersonnel();
		tabbedPane.addTab("Personnel", null, panelPersonnel, null);
	}

}
