package ui.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ui.config.FontStyle;
import javax.swing.JComboBox;

public class PUIPrestataire extends JPanel {

	private static final long serialVersionUID = -3027817538234978409L;
	private JTextField txtNomDetails;
	private JTextField txtAdresseDetails;
	private JTextField txtTypeDetails;
	private JTextField txtLibelleTypeCreation;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PUIPrestataire() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitre = new JLabel("Pr\u00E9stataires");
		lblTitre.setBounds(382, 11, 140, 36);
		lblTitre.setToolTipText("Gestion des s\u00E9minaires");
		lblTitre.setFont(FontStyle.LARGE_TITLE);
		
		JPanel pnlSeparateur = new JPanel();
		pnlSeparateur.setBounds(450, 86, 10, 518);
		
		JList lstPrestataires = new JList();
		lstPrestataires.setBounds(68, 150, 298, 171);
		
		JLabel lblListePrestataires = new JLabel("Listes des pr\u00E9stataires :");
		lblListePrestataires.setBounds(51, 101, 170, 23);
		lblListePrestataires.setFont(FontStyle.TINY_TITLE);
		
		JLabel lblDtailsDuPrestataire = new JLabel("D\u00E9tails du pr\u00E9stataire :");
		lblDtailsDuPrestataire.setBounds(51, 369, 165, 17);
		lblDtailsDuPrestataire.setFont(FontStyle.TINY_TITLE);
		
		JLabel lblNomDetails = new JLabel("Nom :");
		lblNomDetails.setBounds(66, 425, 34, 17);
		lblNomDetails.setFont(FontStyle.LIBELLE);
		
		txtNomDetails = new JTextField();
		txtNomDetails.setBounds(127, 423, 239, 20);
		txtNomDetails.setEditable(false);
		txtNomDetails.setColumns(10);
		
		JLabel lblAdresseDetails = new JLabel("Adresse :");
		lblAdresseDetails.setBounds(66, 463, 51, 17);
		lblAdresseDetails.setFont(FontStyle.LIBELLE);
		
		txtAdresseDetails = new JTextField();
		txtAdresseDetails.setBounds(127, 461, 239, 20);
		txtAdresseDetails.setEditable(false);
		txtAdresseDetails.setColumns(10);
		
		JLabel lblTypeDetails = new JLabel("Type :");
		lblTypeDetails.setBounds(66, 501, 34, 17);
		lblTypeDetails.setFont(FontStyle.LIBELLE);
		
		txtTypeDetails = new JTextField();
		txtTypeDetails.setBounds(127, 499, 239, 20);
		txtTypeDetails.setEditable(false);
		txtTypeDetails.setColumns(10);
		
		JButton btnSupprimerPrestataire = new JButton("Supprimer");
		btnSupprimerPrestataire.setBounds(179, 562, 99, 23);
		btnSupprimerPrestataire.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimerPrestataire.setEnabled(false);
		btnSupprimerPrestataire.setForeground(Color.RED);
		
		JLabel lblCreationType = new JLabel("Cr\u00E9ation type de pr\u00E9stataires :");
		lblCreationType.setBounds(528, 100, 221, 23);
		lblCreationType.setFont(FontStyle.TINY_TITLE);
		
		JList lstTypes = new JList();
		lstTypes.setBounds(549, 152, 210, 87);
		
		JButton btnSupprimerType = new JButton("Supprimer");
		btnSupprimerType.setBounds(832, 181, 99, 23);
		btnSupprimerType.setEnabled(false);
		btnSupprimerType.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimerType.setForeground(Color.RED);
		
		JLabel lblLibelleTypeCreation = new JLabel("Libell\u00E9 Type :");
		lblLibelleTypeCreation.setBounds(549, 281, 73, 17);
		lblLibelleTypeCreation.setFont(FontStyle.LIBELLE);
		
		txtLibelleTypeCreation = new JTextField();
		txtLibelleTypeCreation.setBounds(640, 279, 119, 20);
		txtLibelleTypeCreation.setColumns(10);
		
		JButton btnCreerType = new JButton("Cr\u00E9er");
		btnCreerType.setBounds(832, 278, 99, 23);
		btnCreerType.setEnabled(false);
		btnCreerType.setForeground(Color.GREEN);
		
		JLabel lblCreationPrestataires = new JLabel("Cr\u00E9ation de pr\u00E9stataires :");
		lblCreationPrestataires.setBounds(528, 351, 185, 23);
		lblCreationPrestataires.setFont(FontStyle.TINY_TITLE);
		setLayout(null);
		add(lblTitre);
		add(lblListePrestataires);
		add(lblDtailsDuPrestataire);
		add(lstPrestataires);
		add(lblNomDetails);
		add(lblAdresseDetails);
		add(lblTypeDetails);
		add(txtTypeDetails);
		add(txtNomDetails);
		add(txtAdresseDetails);
		add(btnSupprimerPrestataire);
		add(pnlSeparateur);
		add(lblCreationType);
		add(lblLibelleTypeCreation);
		add(txtLibelleTypeCreation);
		add(lstTypes);
		add(btnSupprimerType);
		add(btnCreerType);
		add(lblCreationPrestataires);
		
		JLabel lblNomPrestaCreation = new JLabel("Nom :");
		lblNomPrestaCreation.setBounds(549, 411, 46, 14);
		lblLibelleTypeCreation.setFont(FontStyle.LIBELLE);
		add(lblNomPrestaCreation);
		
		JLabel lblAdressePrestaCreation = new JLabel("Adresse :");
		lblAdressePrestaCreation.setBounds(549, 436, 46, 14);
		lblLibelleTypeCreation.setFont(FontStyle.LIBELLE);
		add(lblAdressePrestaCreation);
		
		JLabel lblTypePrestaCreation = new JLabel("Type :");
		lblTypePrestaCreation.setBounds(549, 461, 46, 14);
		lblLibelleTypeCreation.setFont(FontStyle.LIBELLE);
		add(lblTypePrestaCreation);
		
		textField = new JTextField();
		textField.setBounds(627, 408, 263, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(627, 433, 263, 20);
		add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(627, 461, 263, 20);
		add(comboBox);
		
		JButton btnCreationPresta = new JButton("Cr\u00E9ation");
		btnCreationPresta.setEnabled(false);
		btnCreationPresta.setForeground(Color.GREEN);
		btnCreationPresta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreationPresta.setBounds(670, 543, 99, 23);
		add(btnCreationPresta);

	}
}
