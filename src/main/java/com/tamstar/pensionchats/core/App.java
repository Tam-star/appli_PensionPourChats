package com.tamstar.pensionchats.core;

import com.tamstar.pensionchats.core.service.ChatService;
import com.tamstar.pensionchats.core.service.ProprietaireService;
import com.tamstar.pensionchats.ui.Fenetre;

public class App {
	public static void main(String[] args) {

		ChatService chatService = new ChatService();
		ProprietaireService proprietaireService = new ProprietaireService();

		Fenetre fen = new Fenetre();
	}
}
