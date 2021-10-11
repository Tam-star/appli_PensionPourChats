package com.tamstar.pensionchats.controller;

import java.util.ArrayList;
import java.util.List;

import com.tamstar.pensionchats.core.entity.Chat;
import com.tamstar.pensionchats.core.service.ChatService;

public class ChatController {

	private ChatService chatService;

	public ChatController() {
		this.chatService = new ChatService();
	}

	public List<String> obtenirListeNomDesChats() {

		List<Chat> liste_chats = chatService.getListChats();
		List<String> liste_noms_chats = new ArrayList<>();
		for (Chat chat : liste_chats) {
			liste_noms_chats.add(chat.getNom());
		}
		return liste_noms_chats;

	}

	public Short retourneIdChat(String nom) {
		Chat chat = chatService.getChat(nom);
		Short id = chat.getId();
		return id;
	}

	public String[] afficherInfoChat(String[] infos, String nom) {

		Chat chat = chatService.getChat(nom);
		infos[0] = "Sexe : " + chat.getSexe();
		infos[1] = "Race : " + chat.getRace();
		infos[2] = "Pelage : " + chat.getPelage();
		infos[3] = "Age : " + chat.getAge() + " ans";
		infos[4] = "Date d'arrivée : " + chat.getDate_arrivee();
		infos[5] = "Date de départ : " + chat.getDate_depart();
		if (chat.getCommentaires() == null) {
			infos[6] = "Commentaires : néant";
		} else {
			infos[6] = "Commentaires : " + chat.getCommentaires();
		}
		return infos;
	}
}
