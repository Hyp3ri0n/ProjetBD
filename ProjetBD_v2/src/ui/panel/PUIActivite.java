package ui.panel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import ui.config.FontStyle;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PUIActivite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7111480489900448613L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PUIActivite() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblActiviteTitre = new JLabel("Acitivit\u00E9");
		lblActiviteTitre.setFont(FontStyle.LARGE_TITLE);
		
		JTabbedPane tabActivite = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(434)
							.addComponent(lblActiviteTitre))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(tabActivite, GroupLayout.PREFERRED_SIZE, 934, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblActiviteTitre)
					.addGap(18)
					.addComponent(tabActivite, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JPanel pnlCreationActivite = new JPanel();
		tabActivite.addTab("Création d'une activité", null, pnlCreationActivite, null);
		pnlCreationActivite.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(460, 41, 10, 460);
		pnlCreationActivite.add(panel);
		
		JLabel lblPrestationTitre = new JLabel("Cr\u00E9ation de prestation :");
		lblPrestationTitre.setFont(FontStyle.TINY_TITLE);
		lblPrestationTitre.setBounds(10, 21, 189, 14);
		pnlCreationActivite.add(lblPrestationTitre);
		
		JLabel lblSupportTitre = new JLabel("Cr\u00E9ation de support :");
		lblSupportTitre.setFont(FontStyle.TINY_TITLE);
		lblSupportTitre.setBounds(513, 22, 168, 14);
		pnlCreationActivite.add(lblSupportTitre);
		
		JLabel lblTitreSupportCrea = new JLabel("Titre :");
		lblTitreSupportCrea.setFont(FontStyle.LIBELLE);
		lblTitreSupportCrea.setBounds(550, 78, 46, 14);
		pnlCreationActivite.add(lblTitreSupportCrea);
		
		JLabel lblCheminSupportCrea = new JLabel("Chemin :");
		lblCheminSupportCrea.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCheminSupportCrea.setBounds(550, 106, 56, 14);
		pnlCreationActivite.add(lblCheminSupportCrea);
		
		JButton btnCreationSupport = new JButton("Cr\u00E9ation");
		btnCreationSupport.setForeground(Color.GREEN);
		btnCreationSupport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreationSupport.setEnabled(false);
		btnCreationSupport.setBounds(648, 173, 97, 23);
		pnlCreationActivite.add(btnCreationSupport);
		
		textField = new JTextField();
		textField.setBounds(627, 75, 267, 20);
		pnlCreationActivite.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(627, 103, 232, 20);
		pnlCreationActivite.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRechercheSupportCrea = new JButton("...");
		btnRechercheSupportCrea.setBounds(863, 102, 31, 23);
		pnlCreationActivite.add(btnRechercheSupportCrea);
		
		JLabel lbl = new JLabel("Titre :");
		lbl.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbl.setBounds(47, 81, 46, 14);
		pnlCreationActivite.add(lbl);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(124, 78, 267, 20);
		pnlCreationActivite.add(textField_2);
		
		JPanel pnlGestion = new JPanel();
		tabActivite.addTab("Gestion des activités", null, pnlGestion, null);
		setLayout(groupLayout);

	}

}
