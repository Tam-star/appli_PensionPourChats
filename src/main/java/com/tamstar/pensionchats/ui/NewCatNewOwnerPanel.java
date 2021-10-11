package com.tamstar.pensionchats.ui;

import java.awt.Dimension;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class NewCatNewOwnerPanel extends JPanel {
	private JLabel nomLabel = new JLabel("Nom du chat : ");
	private JTextField nomTextField = new JTextField("John Doe");
	private JLabel sexeLabel = new JLabel("Sexe du chat : ");
	private JComboBox sexeCombo = new JComboBox();
	private JLabel raceLabel = new JLabel("Race du chat : ");
	private JTextField raceTextField = new JTextField("");
	private JLabel pelageLabel = new JLabel("Pelage du chat : ");
	private JTextField pelageTextField = new JTextField("");
	private JLabel dateArriveeLabel = new JLabel("Date d'arrivée du chat : ");
	private JFormattedTextField dateArriveeTextField = new JFormattedTextField(DateFormat.getDateInstance());
	private JLabel dateDepartLabel = new JLabel("Date de départ du chat : ");
	private JFormattedTextField dateDepartTextField = new JFormattedTextField(DateFormat.getDateInstance());
	private JLabel commentairesLabel = new JLabel("Commentaires : ");
	private JTextField commentairesTextField = new JTextField("");
	private JButton valider = new JButton("Enregistrer");

	private MaskFormatter date;

	public NewCatNewOwnerPanel() {

		sexeCombo.addItem("Mâle");
		sexeCombo.addItem("Femelle");
		sexeCombo.setPreferredSize(new Dimension(100, 20));

		nomTextField.setPreferredSize(new Dimension(100, 20));
		raceTextField.setPreferredSize(new Dimension(100, 20));
		pelageTextField.setPreferredSize(new Dimension(200, 20));
		dateArriveeTextField.setPreferredSize(new Dimension(200, 20));
		dateDepartTextField.setPreferredSize(new Dimension(200, 20));
		commentairesTextField.setPreferredSize(new Dimension(200, 60));

		this.add(nomLabel);
		this.add(nomTextField);
		this.add(sexeLabel);
		this.add(sexeCombo);
		this.add(raceLabel);
		this.add(raceTextField);
		this.add(pelageLabel);
		this.add(pelageTextField);
		this.add(dateArriveeLabel);
		this.add(dateArriveeTextField);
		this.add(dateDepartLabel);
		this.add(dateDepartTextField);
		this.add(commentairesLabel);
		this.add(commentairesTextField);
		this.add(valider);

	}

}
