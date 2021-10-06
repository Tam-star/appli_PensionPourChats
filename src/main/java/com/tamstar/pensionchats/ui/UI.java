package com.tamstar.pensionchats.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.tamstar.pensionchats.controller.ChatController;

public class UI extends JFrame {

	JPanel root_container;
	JPanel pan_left;
	JPanel pan_right;
	JPanel pan_right_up;
	JPanel pan_center_information_chat;
	JPanel pan_right_down;
	JPanel pan_center_information_proprietaire;

	JLabel title_chat;
	JLabel title_proprietaire;

	List<String> liste_noms_chats;
	String[] tab_information_chat = { "Sexe : ", "Race : ", "Pelage : ", "Age : ", "Date d'arrivée : ",
			"Date de départ : ", "Commentaires : " };

	ChatController chatController = new ChatController();

	public UI() {
		this.setTitle("Gestion des chats");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// MENU
		JMenu menu, sous_menu;
		JMenuItem i1, i2, i3, i4;
		JMenuBar mb = new JMenuBar();
		menu = new JMenu("Menu");
		sous_menu = new JMenu("Nouveau Chat");
		i1 = new JMenuItem("Nouveau Propriétaire");
		i2 = new JMenuItem("Propriétaire déjà enregistré");
		i3 = new JMenuItem("Description des chats");
		i4 = new JMenuItem("Départ d'un chat");
		sous_menu.add(i1);
		sous_menu.add(i2);
		menu.add(sous_menu);
		menu.add(i3);
		menu.add(i4);
		mb.add(menu);
		this.setJMenuBar(mb);

		// ROOT PANEL
		root_container = new JPanel();
		root_container.setLayout(new GridLayout(1, 2));

		// INFORMATION PANEL
		pan_right = new JPanel();
		pan_right.setLayout(new GridLayout(2, 1));
		pan_right.setBorder(BorderFactory.createLineBorder(new Color(249, 158, 158), 3));

		// INFORMATION CHAT PANEL
		pan_right_up = new JPanel();
		pan_right_up.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		pan_right_up.setLayout(new BorderLayout());

		title_chat = new JLabel("CHAT", JLabel.CENTER);
		title_chat.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title_chat.setPreferredSize(new Dimension(50, 50));
		pan_right_up.add(title_chat, BorderLayout.NORTH);

		pan_center_information_chat = new JPanel();
		pan_center_information_chat.setLayout(new GridLayout(4, 2));
		pan_center_information_chat.setBorder(new EmptyBorder(15, 15, 15, 15));

		for (int i = 0; i < tab_information_chat.length; i++) {
			pan_center_information_chat.add(new JLabel(tab_information_chat[i]));
		}

		pan_right_up.add(pan_center_information_chat, BorderLayout.CENTER);

		// LISTE DES CHATS
		pan_left = new JPanel();
		pan_left.setLayout(new GridLayout(10, 1));

		liste_noms_chats = chatController.obtenirListeNomDesChats();
		for (int i = 0; i < liste_noms_chats.size(); i++) {
			JLabel label = new JLabel(liste_noms_chats.get(i), JLabel.CENTER);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			label.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					String nom = label.getText();
					title_chat.setText(nom.toUpperCase());
					// affiche le reste des infos du chat
					tab_information_chat = chatController.afficherInfoChat(tab_information_chat, nom);
					pan_center_information_chat.removeAll();
					for (int i = 0; i < tab_information_chat.length; i++) {
						pan_center_information_chat.add(new JLabel(tab_information_chat[i]));
					}
				}
			});
			pan_left.add(label);
		}

		// INFORMATION PROPRIETAIRE PANEL
		pan_right_down = new JPanel();
		pan_right_down.setLayout(new BorderLayout());
		title_proprietaire = new JLabel("PROPRIETAIRE", JLabel.CENTER);
		title_proprietaire.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title_proprietaire.setPreferredSize(new Dimension(50, 50));
		pan_right_down.add(title_proprietaire, BorderLayout.NORTH);

		pan_center_information_proprietaire = new JPanel();
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

}
