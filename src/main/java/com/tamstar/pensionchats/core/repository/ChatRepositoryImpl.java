package com.tamstar.pensionchats.core.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.tamstar.pensionchats.core.HibernateUtil;
import com.tamstar.pensionchats.core.entity.Chat;

public class ChatRepositoryImpl {

	public void create(Chat chat) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.persist(chat);
		System.out.println("Chat créé");

	}

	public Chat getById(Short id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Chat chat = session.get(Chat.class, id);
		return chat;
	}

	public Chat getByName(String name) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Chat chat = session.get(Chat.class, name);
		return chat;
	}

	public List<Chat> getAllCats() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Query<Chat> query = session.createQuery("select c from Chat c", Chat.class);
		List<Chat> liste_chats = query.getResultList();
		return liste_chats;
	}

	public void delete(Short id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(getById(id));
		System.out.println("Chat supprimé");
	}

}
