package ui.panel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import ui.config.FontStyle;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;

public class PUIInscription extends JPanel {

	private static final long serialVersionUID = 5634865802601374235L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PUIInscription() {
		setBackground(Color.LIGHT_GRAY);
		
		JLabel lblInscriptionTitre = new JLabel("Inscription");
		lblInscriptionTitre.setFont(FontStyle.LARGE_TITLE);
		
		JLabel lblListeSeminaire = new JLabel("Liste de s\u00E9minaire :");
		lblListeSeminaire.setFont(FontStyle.TINY_TITLE);
		
		table = new JTable();
		
		JList list = new JList();
		
		JList list_1 = new JList();
		
		JButton button = new JButton(">");
		button.setEnabled(false);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton button_1 = new JButton("<");
		button_1.setEnabled(false);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton button_2 = new JButton("<<");
		button_2.setEnabled(false);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblListeallPers = new JLabel("Liste de toutes les personnes :");
		lblListeallPers.setFont(FontStyle.TINY_TITLE);
		
		JLabel lblListePersonnesPresentes = new JLabel("Liste de toutes les personnes pr\u00E9setes au s\u00E9minaire :");
		lblListePersonnesPresentes.setFont(FontStyle.TINY_TITLE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(427)
							.addComponent(lblInscriptionTitre))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 895, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(560, Short.MAX_VALUE)
							.addComponent(lblListePersonnesPresentes, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(49, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addGap(108)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addGap(79))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblListeallPers, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListeSeminaire))
					.addContainerGap(696, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInscriptionTitre)
					.addGap(18)
					.addComponent(lblListeSeminaire)
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblListeallPers, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListePersonnesPresentes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2)
							.addGap(97))))
		);
		setLayout(groupLayout);

	}

}
