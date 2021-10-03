package com.tamstar.pensionchats.core.service;

import java.util.List;

import com.tamstar.pensionchats.core.entity.Chat;
import com.tamstar.pensionchats.core.repository.ChatRepositoryImpl;

public class ChatService {

	private ChatRepositoryImpl chatRepository;

	public ChatService() {
		this.chatRepository = new ChatRepositoryImpl();
	}

	public void creerChat(Chat chat) {
		chatRepository.create(chat);
	}

	public Chat getChat(Short id) {
		return chatRepository.getById(id);
	}

	public List<Chat> getListChats() {
		return chatRepository.getAllCats();
	}

	public void supprimerChat(Long id) {
		chatRepository.delete(id);
	}
}
