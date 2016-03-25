package ui.panel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import ui.config.FontStyle;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PUIPersonnel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 147556828336365462L;
	private JTable tabAllPersonnes;
	private JTextField txtNomCrea;
	private JTextField txtPrenomCrea;
	private JTextField txtAdresseCrea;
	private JTextField txtTelCrea;
	private JTextField txtMailCrea;

	/**
	 * Create the panel.
	 */
	public PUIPersonnel() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblPersonnelTitre = new JLabel("Personnel");
		lblPersonnelTitre.setBounds(427, 11, 116, 36);
		lblPersonnelTitre.setFont(FontStyle.LARGE_TITLE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 288, 895, 10);
		setLayout(null);
		add(panel_1);
		add(lblPersonnelTitre);
		
		JLabel lblPersonneTitre = new JLabel("Personne :");
		lblPersonneTitre.setBounds(41, 80, 116, 14);
		lblPersonneTitre.setFont(FontStyle.SMALL_TITLE);
		add(lblPersonneTitre);
		
		JLabel lblAllTitre = new JLabel("Liste de tout le monde :");
		lblAllTitre.setBounds(69, 332, 205, 14);
		lblAllTitre.setFont(FontStyle.SMALL_TITLE);
		add(lblAllTitre);
		
		tabAllPersonnes = new JTable();
		tabAllPersonnes.setBounds(69, 357, 876, 180);
		add(tabAllPersonnes);
		
		JButton btnSupprPersonneInTabAll = new JButton("Supprimer");
		btnSupprPersonneInTabAll.setEnabled(false);
		btnSupprPersonneInTabAll.setForeground(Color.RED);
		btnSupprPersonneInTabAll.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprPersonneInTabAll.setBounds(437, 570, 98, 23);
		add(btnSupprPersonneInTabAll);
		
		JLabel lblNomAnimCrea = new JLabel("Nom :");
		lblNomAnimCrea.setBounds(69, 124, 46, 14);
		lblNomAnimCrea.setFont(FontStyle.LIBELLE);
		add(lblNomAnimCrea);
		
		JLabel lblPrenomAnimCrea = new JLabel("Prenom :");
		lblPrenomAnimCrea.setBounds(69, 149, 60, 14);
		lblPrenomAnimCrea.setFont(FontStyle.LIBELLE);
		add(lblPrenomAnimCrea);
		
		JLabel lblAdresseAnimCrea = new JLabel("Adresse :");
		lblAdresseAnimCrea.setBounds(69, 174, 60, 14);
		lblAdresseAnimCrea.setFont(FontStyle.LIBELLE);
		add(lblAdresseAnimCrea);
		
		JLabel lblTelAnimCrea = new JLabel("Tel. :");
		lblTelAnimCrea.setBounds(69, 199, 46, 14);
		lblTelAnimCrea.setFont(FontStyle.LIBELLE);
		add(lblTelAnimCrea);
		
		JLabel lblMailAnimCrea = new JLabel("Mail :");
		lblMailAnimCrea.setBounds(496, 127, 46, 14);
		lblMailAnimCrea.setFont(FontStyle.LIBELLE);
		add(lblMailAnimCrea);
		
		JButton btnCreationAnim = new JButton("Cr\u00E9ation");
		btnCreationAnim.setEnabled(false);
		btnCreationAnim.setForeground(Color.GREEN);
		btnCreationAnim.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreationAnim.setBounds(437, 241, 89, 23);
		add(btnCreationAnim);
		
		txtNomCrea = new JTextField();
		txtNomCrea.setBounds(140, 121, 280, 20);
		add(txtNomCrea);
		txtNomCrea.setColumns(10);
		
		txtPrenomCrea = new JTextField();
		txtPrenomCrea.setBounds(139, 146, 281, 20);
		add(txtPrenomCrea);
		txtPrenomCrea.setColumns(10);
		
		txtAdresseCrea = new JTextField();
		txtAdresseCrea.setColumns(10);
		txtAdresseCrea.setBounds(139, 171, 281, 20);
		add(txtAdresseCrea);
		
		txtTelCrea = new JTextField();
		txtTelCrea.setColumns(10);
		txtTelCrea.setBounds(140, 196, 281, 20);
		add(txtTelCrea);
		
		txtMailCrea = new JTextField();
		txtMailCrea.setColumns(10);
		txtMailCrea.setBounds(567, 124, 281, 20);
		add(txtMailCrea);
		
		JLabel lblTypePersonne = new JLabel("Type :");
		lblTypePersonne.setFont(FontStyle.LIBELLE);
		lblTypePersonne.setBounds(496, 152, 46, 14);
		add(lblTypePersonne);
		
		JRadioButton rbtnTypePersonne = new JRadioButton("Personne");
		rbtnTypePersonne.setBounds(567, 145, 71, 23);
		add(rbtnTypePersonne);
		
		JRadioButton rbtnTypeAnimateur = new JRadioButton("Animateur");
		rbtnTypeAnimateur.setBounds(650, 145, 80, 23);
		add(rbtnTypeAnimateur);
		
		JRadioButton rbtnTypeConferencier = new JRadioButton("Conf\u00E9rencier");
		rbtnTypeConferencier.setBounds(743, 145, 105, 23);
		add(rbtnTypeConferencier);

	}
}
