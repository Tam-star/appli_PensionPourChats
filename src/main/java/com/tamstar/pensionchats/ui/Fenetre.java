package com.tamstar.pensionchats.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Fenetre extends JFrame {

	public Fenetre() {
		this.setTitle("Gestion des chats");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel root_container = new JPanel();
		root_container.setLayout(new GridLayout(1, 2));

		// LISTE DES CHATS
		JPanel pan_left = new JPanel();
		pan_left.setLayout(new GridLayout(10, 1));

		String[] tab_noms_chats = { "Chouchou", "Wally", "Pelotte", "Mouskif", "Batman", "Grizzli", "Paupiette" };

		for (int i = 0; i < tab_noms_chats.length; i++) {
			JLabel label = new JLabel(tab_noms_chats[i], JLabel.CENTER);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			label.addMouseListener(new MouseEventInformation());
			pan_left.add(label);
		}

		// INFORMATION PANEL
		JPanel pan_right = new JPanel();
		pan_right.setLayout(new GridLayout(2, 1));
		pan_right.setBorder(BorderFactory.createLineBorder(new Color(249, 158, 158), 3));

		// INFORMATION CHAT PANEL
		JPanel pan_right_up = new JPanel();
		pan_right_up.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		pan_right_up.setLayout(new BorderLayout());

		JLabel title_chat = new JLabel("WALLY", JLabel.CENTER);
		title_chat.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title_chat.setPreferredSize(new Dimension(50, 50));
		pan_right_up.add(title_chat, BorderLayout.NORTH);

		JPanel pan_center_information_chat = new JPanel();
		pan_center_information_chat.setLayout(new GridLayout(4, 2));
		pan_center_information_chat.setBorder(new EmptyBorder(15, 15, 15, 15));
		String[] tab_information_chat = { "Sexe : ", "Race : ", "Pelage : ", "Age : ", "Date d'arrivée : ",
				"Date de départ : ", "Commentaires : " };
		for (int i = 0; i < tab_information_chat.length; i++) {
			pan_center_information_chat.add(new JLabel(tab_information_chat[i]));
		}

		pan_right_up.add(pan_center_information_chat, BorderLayout.CENTER);

		// INFORMATION PROPRIETAIRE PANEL
		JPanel pan_right_down = new JPanel();
		pan_right_down.setLayout(new BorderLayout());
		JLabel title_proprietaire = new JLabel("PROPRIETAIRE", JLabel.CENTER);
		title_proprietaire.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title_proprietaire.setPreferredSize(new Dimension(50, 50));
		pan_right_down.add(title_proprietaire, BorderLayout.NORTH);

		JPanel pan_center_information_proprietaire = new JPanel();
		pan_center_information_proprietaire.setLayout(new GridLayout(3, 1));
		pan_center_information_proprietaire.setBorder(new EmptyBorder(15, 15, 15, 15));

		String[] tab_information_proprietaire = { "Nom : ", "Prénom : ", "Téléphone : " };
		for (int i = 0; i < tab_information_proprietaire.length; i++) {
			pan_center_information_proprietaire.add(new JLabel(tab_information_proprietaire[i]));
		}
		pan_right_down.add(pan_center_information_proprietaire, BorderLayout.CENTER);

		pan_right.add(pan_right_up);
		pan_right.add(pan_right_down);

		root_container.add(pan_left);
		root_container.add(pan_right);

		this.setContentPane(root_container);
		this.setVisible(true);
	}

	// Listener affecté à chaque JLabel de la liste des chats
	class InformationListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Cliqué!");

		}
	}

	class MouseEventInformation implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.out.println("Cliqué!");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
