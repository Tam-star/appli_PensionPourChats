package com.tamstar.pensionchats.ui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tamstar.pensionchats.core.service.ChatService;

public class Fenetre extends JFrame {

	private JButton bouton = new JButton("Mon bouton");
	// JLabel label = new JLabel();
	ChatService chatService = new ChatService();

	public Fenetre() {
		this.setTitle("Gestion des chats");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Instanciation d'un objet JPanel
		JPanel pan = new JPanel();
		pan.setBackground(Color.ORANGE);
		pan.setLayout(new GridLayout(3, 3));
		this.setContentPane(pan);
		this.setVisible(true);
	}

}
