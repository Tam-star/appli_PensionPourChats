package com.tamstar.pensionchats.core.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tamstar.pensionchats.core.HibernateUtil;
import com.tamstar.pensionchats.core.entity.Chat;
import com.tamstar.pensionchats.core.repository.ChatRepositoryImpl;

public class ChatService {

	private ChatRepositoryImpl chatRepository;

	public ChatService() {
		this.chatRepository = new ChatRepositoryImpl();
	}

	public void creerChat(Chat chat) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			chatRepository.create(chat);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public Chat getChat(Short id) {

		Session session = null;
		Transaction tx = null;
		Chat chat = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			chat = chatRepository.getById(id);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return chat;
	}

	public Chat getChat(String nom) {

		Session session = null;
		Transaction tx = null;
		Chat chat = null;
		List<Chat> liste_chats = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			liste_chats = chatRepository.getAllCats();
			for (int i = 0; i < liste_chats.size(); i++) {
				Chat chatListe = liste_chats.get(i);
				if (chatListe.getNom().equals(nom)) {
					chat = liste_chats.get(i);
				}
			}
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return chat;
	}

	public List<Chat> getListChats() {
		Session session = null;
		Transaction tx = null;
		List<Chat> liste_chats = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			liste_chats = chatRepository.getAllCats();
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return liste_chats;
	}

	public void supprimerChat(Short id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			chatRepository.delete(id);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
