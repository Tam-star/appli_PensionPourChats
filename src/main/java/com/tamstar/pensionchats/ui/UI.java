package com.tamstar.pensionchats.ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class UI extends JFrame {

	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	// Liste des noms de conteneurs pour le CardLayout
	String[] listContent = { "NOUVEAU_PROPRIETAIRE", "PROPRIETAIRE_CONNU", "DESCRIPTION_CHAT", "DEPART_CHAT" };

	public UI() {
		this.setTitle("Gestion des chats");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(content);

		// On crée les conteneurs différents pour le menu
		NewCatNewOwnerPanel nouveauChatAvecNouveauProprio = new NewCatNewOwnerPanel();
		JPanel nouveauChatProprioConnu = new JPanel();
		nouveauChatProprioConnu.add(new JLabel("Propriétaire du chat connu"));
		DescriptionChatPanel panelDescription = new DescriptionChatPanel();
		JPanel departChat = new JPanel();
		departChat.add(new JLabel("Un chat s'en va"));

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

		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, listContent[0]);
			}
		});

		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, listContent[1]);
			}
		});

		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, listContent[2]);
			}
		});

		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(content, listContent[3]);
			}
		});

		content.setLayout(cl);
		content.add(nouveauChatAvecNouveauProprio, listContent[0]);
		content.add(nouveauChatProprioConnu, listContent[1]);
		content.add(panelDescription, listContent[2]);
		content.add(departChat, listContent[3]);

		this.setVisible(true);
	}

}
