package com.tamstar.pensionchats.core;

import com.tamstar.pensionchats.core.entity.Chat;
import com.tamstar.pensionchats.core.entity.Proprietaire;
import com.tamstar.pensionchats.core.service.ChatService;
import com.tamstar.pensionchats.core.service.ProprietaireService;

public class App {
	public static void main(String[] args) {

		ChatService chatService = new ChatService();
		ProprietaireService proprietaireService = new ProprietaireService();

		Proprietaire prop = proprietaireService.getProprietaire((short) 3);

		System.out.println(
				"Propriétaire : " + prop.getPrenom() + " " + prop.getNom() + ", téléphone : " + prop.getTelephone());

		Chat chat = chatService.getChat((short) 3);

		System.out.println(chat.getNom() + " de pelage " + chat.getPelage() + " âgé de " + chat.getAge() + " ans.");

		/*
		 * List<Chat> liste = chatService.getListChats();
		 * 
		 * for (Chat c : liste) { System.out.println(c.getNom() + " appartient à " +
		 * c.getProprietaire().getNom()); }
		 */

		// Fenetre fen = new Fenetre();
	}
}
