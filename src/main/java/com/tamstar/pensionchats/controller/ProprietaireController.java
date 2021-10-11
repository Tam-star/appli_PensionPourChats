package com.tamstar.pensionchats.controller;

import com.tamstar.pensionchats.core.entity.Chat;
import com.tamstar.pensionchats.core.entity.Proprietaire;
import com.tamstar.pensionchats.core.service.ChatService;
import com.tamstar.pensionchats.core.service.ProprietaireService;

public class ProprietaireController {

	private ProprietaireService proprietaireService;
	private ChatService chatService;

	public ProprietaireController() {
		this.proprietaireService = new ProprietaireService();
		this.chatService = new ChatService();

	}

	public String[] afficherInfoProprietaireDuChat(String[] infos, String nom_chat) {

		Chat chat = chatService.getChat(nom_chat);
		Proprietaire proprietaire = chat.getProprietaire();
		infos[0] = "Nom : " + proprietaire.getNom();
		infos[1] = "Prénom : " + proprietaire.getPrenom();
		infos[2] = "Téléphone : " + proprietaire.getTelephone();
		return infos;
	}

}
