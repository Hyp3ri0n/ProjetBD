package ui.panel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.config.FontStyle;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PUIAccueil extends JPanel {

	private static final long serialVersionUID = 3150019946435180412L;

	/**
	 * Create the panel.
	 */
	public PUIAccueil() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitre = new JLabel("Accueil");
		lblTitre.setBounds(446, 11, 84, 36);
		lblTitre.setFont(FontStyle.LARGE_TITLE);
		
		JLabel lblDesc = new JLabel("Ceci est une application r\u00E9alis\u00E9e par MARTINIER Alexis & FERNANDES Aur\u00E9lien dans le cadre d'un projet universitaire en L3 MIAGE pour l'UE Base de Donn\u00E9es (BD).");
		lblDesc.setBounds(29, 108, 916, 52);
		lblDesc.setFont(FontStyle.LIBELLE);
		setLayout(null);
		
		JLabel lblUniversitGrenobleAlpes = new JLabel("Universit\u00E9 Grenoble Alpes");
		lblUniversitGrenobleAlpes.setBounds(815, 597, 152, 17);
		lblUniversitGrenobleAlpes.setFont(new Font("Calibri", Font.PLAIN, 14));
		add(lblUniversitGrenobleAlpes);
		add(lblTitre);
		add(lblDesc);

	}
}