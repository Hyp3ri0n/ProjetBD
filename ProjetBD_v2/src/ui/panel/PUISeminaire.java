package ui.panel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.config.FontStyle;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;

public class PUISeminaire extends JPanel {

	private static final long serialVersionUID = -718415524182143515L;
	private JTable tblSemModifier;
	private JTextField txtThemeSem;

	/**
	 * Create the panel.
	 */
	public PUISeminaire() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblTitre = new JLabel("S\u00E9minaire");
		lblTitre.setToolTipText("Gestion des s\u00E9minaires");
		lblTitre.setFont(FontStyle.LARGE_TITLE);
		
		JTabbedPane tabsPan = new JTabbedPane(JTabbedPane.TOP);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(413)
							.addComponent(lblTitre))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(tabsPan, GroupLayout.PREFERRED_SIZE, 899, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tabsPan, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JPanel pnlModifSem = new JPanel();
		tabsPan.addTab("Modification", null, pnlModifSem, null);
		pnlModifSem.setLayout(null);
		
		JLabel lblModifSminaire = new JLabel("Confirmation/Suppression d'un s\u00E9minaire");
		lblModifSminaire.setBounds(283, 29, 352, 26);
		lblModifSminaire.setFont(FontStyle.SMALL_TITLE);
		pnlModifSem.add(lblModifSminaire);
		
		tblSemModifier = new JTable();
		tblSemModifier.setBounds(56, 97, 774, 294);
		pnlModifSem.add(tblSemModifier);
		
		JButton btnConfirmationSem = new JButton("Confirmer");
		btnConfirmationSem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmationSem.setBounds(259, 423, 96, 23);
		btnConfirmationSem.setEnabled(false);
		btnConfirmationSem.setForeground(Color.GREEN);
		pnlModifSem.add(btnConfirmationSem);
		
		JButton btnSupprimerSem = new JButton("Supprimer");
		btnSupprimerSem.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSupprimerSem.setBounds(513, 423, 96, 23);
		btnSupprimerSem.setEnabled(false);
		btnSupprimerSem.setForeground(Color.RED);
		pnlModifSem.add(btnSupprimerSem);
		
		JPanel pnlCreaSem = new JPanel();
		tabsPan.addTab("Création", null, pnlCreaSem, null);
		pnlCreaSem.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(426, 63, 10, 427);
		pnlCreaSem.add(panel_1);
		
		JLabel lblThemeSem = new JLabel("Theme :");
		lblThemeSem.setBounds(25, 85, 46, 14);
		lblThemeSem.setFont(FontStyle.LIBELLE);
		pnlCreaSem.add(lblThemeSem);
		
		JLabel lblTypeSem = new JLabel("Type :");
		lblTypeSem.setFont(FontStyle.LIBELLE);
		lblTypeSem.setBounds(25, 110, 46, 14);
		pnlCreaSem.add(lblTypeSem);
		
		JLabel lblDateSem = new JLabel("Date (jj/mm/aaaa) :");
		lblDateSem.setFont(FontStyle.LIBELLE);
		lblDateSem.setBounds(25, 135, 118, 14);
		pnlCreaSem.add(lblDateSem);
		
		JLabel lblCreaSemForm = new JLabel("Cr\u00E9ation d'un s\u00E9minaire");
		lblCreaSemForm.setFont(FontStyle.SMALL_TITLE);
		lblCreaSemForm.setBounds(333, 11, 202, 20);
		pnlCreaSem.add(lblCreaSemForm);
		
		JLabel lblAnimSem = new JLabel("Animateur :");
		lblAnimSem.setFont(FontStyle.LIBELLE);
		lblAnimSem.setBounds(25, 160, 74, 14);
		pnlCreaSem.add(lblAnimSem);
		
		JLabel lblPrestataireSem = new JLabel("Prestataire :");
		lblPrestataireSem.setFont(FontStyle.LIBELLE);
		lblPrestataireSem.setBounds(25, 206, 74, 14);
		pnlCreaSem.add(lblPrestataireSem);
		
		JLabel lblSalleSem = new JLabel("Salle :");
		lblSalleSem.setFont(FontStyle.LIBELLE);
		lblSalleSem.setBounds(25, 231, 46, 14);
		pnlCreaSem.add(lblSalleSem);
		
		JLabel lblNbPlacesSem = new JLabel("Nb. de place :");
		lblNbPlacesSem.setFont(FontStyle.LIBELLE);
		lblNbPlacesSem.setBounds(25, 256, 84, 14);
		pnlCreaSem.add(lblNbPlacesSem);
		
		JLabel lblTarifpersSem = new JLabel("Tarif/pers. :");
		lblTarifpersSem.setBounds(25, 281, 74, 14);
		pnlCreaSem.add(lblTarifpersSem);
		
		JLabel lblPausesSem = new JLabel("Pauses (tarifs) :");
		lblPausesSem.setBounds(25, 332, 84, 14);
		pnlCreaSem.add(lblPausesSem);
		
		JCheckBox chbPauseAMSem = new JCheckBox("AM");
		chbPauseAMSem.setEnabled(false);
		chbPauseAMSem.setBounds(46, 353, 66, 23);
		pnlCreaSem.add(chbPauseAMSem);
		
		JCheckBox chbPausePMSem = new JCheckBox("PM");
		chbPausePMSem.setEnabled(false);
		chbPausePMSem.setBounds(46, 379, 63, 23);
		pnlCreaSem.add(chbPausePMSem);
		
		JCheckBox chbPauseDejSem = new JCheckBox("D\u00E9jeuner");
		chbPauseDejSem.setEnabled(false);
		chbPauseDejSem.setBounds(46, 405, 78, 23);
		pnlCreaSem.add(chbPauseDejSem);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(152, 354, 113, 20);
		pnlCreaSem.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(152, 380, 113, 20);
		pnlCreaSem.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(152, 406, 113, 20);
		pnlCreaSem.add(spinner_2);
		
		txtThemeSem = new JTextField();
		txtThemeSem.setBounds(152, 82, 218, 20);
		pnlCreaSem.add(txtThemeSem);
		txtThemeSem.setColumns(10);
		
		JComboBox cboTypeSem = new JComboBox();
		cboTypeSem.setBounds(152, 107, 218, 20);
		pnlCreaSem.add(cboTypeSem);
		
		JSpinner spnDateJourSem = new JSpinner();
		spnDateJourSem.setBounds(153, 132, 40, 20);
		pnlCreaSem.add(spnDateJourSem);
		
		JLabel lblSepDate1Sem = new JLabel("/");
		lblSepDate1Sem.setFont(FontStyle.LIBELLE);
		lblSepDate1Sem.setBounds(205, 135, 10, 14);
		pnlCreaSem.add(lblSepDate1Sem);
		
		JSpinner spnDateMoisSem = new JSpinner();
		spnDateMoisSem.setBounds(225, 132, 40, 20);
		pnlCreaSem.add(spnDateMoisSem);
		
		JLabel lblSepDate2Sem = new JLabel("/");
		lblSepDate2Sem.setFont(FontStyle.LIBELLE);
		lblSepDate2Sem.setBounds(285, 135, 10, 14);
		pnlCreaSem.add(lblSepDate2Sem);
		
		JSpinner spnDateAnneeSem = new JSpinner();
		spnDateAnneeSem.setBounds(305, 132, 65, 20);
		pnlCreaSem.add(spnDateAnneeSem);
		
		JComboBox cboAnimateurSem = new JComboBox();
		cboAnimateurSem.setBounds(152, 160, 218, 20);
		pnlCreaSem.add(cboAnimateurSem);
		
		JComboBox cboPrestataireSem = new JComboBox();
		cboPrestataireSem.setBounds(152, 203, 218, 20);
		pnlCreaSem.add(cboPrestataireSem);
		
		JComboBox cboSalleSem = new JComboBox();
		cboSalleSem.setBounds(152, 228, 218, 20);
		pnlCreaSem.add(cboSalleSem);
		
		JSpinner spnNbPlacesSem = new JSpinner();
		spnNbPlacesSem.setBounds(152, 253, 113, 20);
		pnlCreaSem.add(spnNbPlacesSem);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(152, 278, 113, 20);
		pnlCreaSem.add(spinner_3);
		
		JLabel lblEuros1 = new JLabel("\u20AC");
		lblEuros1.setBounds(285, 281, 10, 14);
		pnlCreaSem.add(lblEuros1);
		
		JLabel lblEuro2 = new JLabel("\u20AC");
		lblEuro2.setBounds(285, 357, 10, 14);
		pnlCreaSem.add(lblEuro2);
		
		JLabel lblEuro3 = new JLabel("\u20AC");
		lblEuro3.setBounds(285, 383, 10, 14);
		pnlCreaSem.add(lblEuro3);
		
		JLabel lblEuro4 = new JLabel("\u20AC");
		lblEuro4.setBounds(285, 409, 10, 14);
		pnlCreaSem.add(lblEuro4);
		
		JLabel lblPersonnesPlacesSem = new JLabel("personnes");
		lblPersonnesPlacesSem.setBounds(285, 256, 63, 14);
		pnlCreaSem.add(lblPersonnesPlacesSem);
		
		JLabel lblActivitesSem = new JLabel("Activit\u00E9s :");
		lblActivitesSem.setFont(FontStyle.LIBELLE);
		lblActivitesSem.setBounds(490, 85, 66, 14);
		pnlCreaSem.add(lblActivitesSem);
		
		JList lstActivitesSem = new JList();
		lstActivitesSem.setBounds(490, 135, 349, 241);
		pnlCreaSem.add(lstActivitesSem);
		
		JButton btnCreationSem = new JButton("Cr\u00E9ation");
		btnCreationSem.setEnabled(false);
		btnCreationSem.setForeground(Color.GREEN);
		btnCreationSem.setBounds(624, 433, 89, 23);
		pnlCreaSem.add(btnCreationSem);
		setLayout(groupLayout);

	}
}
