package com.tamstar.pensionchats.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class NewCatNewOwnerPanel extends JPanel {
	private JLabel nomLabel;
	private JTextField nomTextField;
	private JLabel sexeLabel;
	private JComboBox sexeCombo;
	private JLabel raceLabel;
	private JTextField raceTextField;
	private JLabel pelageLabel;
	private JTextField pelageTextField;
	private JLabel dateArriveeLabel;
	private JFormattedTextField dateArriveeTextField;
	private JLabel dateDepartLabel;
	private JFormattedTextField dateDepartTextField;
	private JLabel commentairesLabel;
	private JTextArea commentairesTextArea;

	private JLabel nomProprioLabel;
	private JTextField nomProprioTextField;
	private JLabel prenomProprioLabel;
	private JTextField prenomProprioTextField;
	private JLabel telephoneProprioLabel;
	private JFormattedTextField telephoneTextField;

	private JButton valider;

	private MaskFormatter telephoneMask;

	private JPanel main_container;
	private JPanel top_panel_chat;
	private JPanel bottom_panel_proprio;

	public NewCatNewOwnerPanel() {

		this.setLayout(new BorderLayout());
		main_container = new JPanel();
		this.add(main_container, BorderLayout.CENTER);
		valider = new JButton("Enregistrer");
		this.add(valider, BorderLayout.SOUTH);

		// CENTER CONTAINER
		main_container.setLayout(new GridLayout(2, 1));
		top_panel_chat = new JPanel();
		bottom_panel_proprio = new JPanel();
		main_container.add(top_panel_chat);
		main_container.add(bottom_panel_proprio);

		nomLabel = new JLabel("Nom du chat : ");
		nomTextField = new JTextField("John Doe");
		sexeLabel = new JLabel("Sexe du chat : ");
		sexeCombo = new JComboBox();
		raceLabel = new JLabel("Race du chat : ");
		raceTextField = new JTextField("race");
		pelageLabel = new JLabel("Pelage du chat : ");
		pelageTextField = new JTextField("pelage");

		dateArriveeLabel = new JLabel("Date d'arrivée du chat : ");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		dateArriveeTextField = new JFormattedTextField(dateFormat);
		dateArriveeTextField.setValue(new Date());
		dateDepartLabel = new JLabel("Date de départ du chat : ");
		dateDepartTextField = new JFormattedTextField(dateFormat);
		dateDepartTextField.setValue(new Date());

		commentairesLabel = new JLabel("Commentaires : ");
		commentairesTextArea = new JTextArea("");

		nomProprioLabel = new JLabel("Nom du propriétaire : ");
		nomProprioTextField = new JTextField("");
		prenomProprioLabel = new JLabel("Prénom du propriétaire : ");
		prenomProprioTextField = new JTextField("");

		telephoneProprioLabel = new JLabel("Téléphone : ");
		try {
			telephoneMask = new MaskFormatter("##-##-##-##-##");
			telephoneMask.setPlaceholderCharacter('#');
			telephoneTextField = new JFormattedTextField(telephoneMask);
		} catch (Exception e) {
			e.printStackTrace();
			telephoneTextField = new JFormattedTextField();
		}

		sexeCombo.addItem("Mâle");
		sexeCombo.addItem("Femelle");
		sexeCombo.setPreferredSize(new Dimension(100, 20));

		nomTextField.setPreferredSize(new Dimension(100, 25));
		raceTextField.setPreferredSize(new Dimension(100, 25));
		pelageTextField.setPreferredSize(new Dimension(100, 25));
		dateArriveeTextField.setPreferredSize(new Dimension(100, 25));
		dateDepartTextField.setPreferredSize(new Dimension(100, 25));
		commentairesTextArea.setPreferredSize(new Dimension(200, 60));
		nomProprioTextField.setPreferredSize(new Dimension(200, 25));
		prenomProprioTextField.setPreferredSize(new Dimension(200, 25));
		telephoneTextField.setPreferredSize(new Dimension(100, 25));

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		top_panel_chat.setLayout(layout);
		gbc.insets = new Insets(7, 7, 7, 7);
		gbc.weightx = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		top_panel_chat.add(nomLabel, gbc);
		gbc.weightx = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		top_panel_chat.add(nomTextField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		top_panel_chat.add(sexeLabel, gbc);
		gbc.weightx = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		top_panel_chat.add(sexeCombo, gbc);
		gbc.weightx = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		// gbc.gridwidth = 2;
		top_panel_chat.add(raceLabel, gbc);
		gbc.weightx = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		top_panel_chat.add(raceTextField, gbc);
		gbc.weightx = 1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		top_panel_chat.add(pelageLabel, gbc);
		gbc.weightx = 1;
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		top_panel_chat.add(pelageTextField, gbc);
		gbc.weightx = 1;
		gbc.gridx = 2;
		gbc.gridy = 1;
		top_panel_chat.add(dateArriveeLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		top_panel_chat.add(dateArriveeTextField, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		top_panel_chat.add(dateDepartLabel, gbc);
		gbc.gridx = 3;
		gbc.gridy = 2;
		top_panel_chat.add(dateDepartTextField, gbc);
		gbc.gridx = 4;
		gbc.gridy = 0;
		top_panel_chat.add(commentairesLabel, gbc);
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		top_panel_chat.add(commentairesTextArea, gbc);

		bottom_panel_proprio.add(nomProprioLabel);
		bottom_panel_proprio.add(nomProprioTextField);
		bottom_panel_proprio.add(prenomProprioLabel);
		bottom_panel_proprio.add(prenomProprioTextField);
		bottom_panel_proprio.add(telephoneProprioLabel);
		bottom_panel_proprio.add(telephoneTextField);

	}

}
