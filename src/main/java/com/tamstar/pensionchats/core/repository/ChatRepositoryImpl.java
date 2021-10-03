package com.tamstar.pensionchats.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;

import com.tamstar.pensionchats.core.DataSourceProvider;
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

	public List<Chat> getAllCats() {

		Connection conn = null;
		List<Chat> liste_chats = new ArrayList<>();

		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CHAT");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Chat chat = new Chat();
				chat.setId(rs.getShort("ID"));
				chat.setAge(rs.getByte("AGE"));
				chat.setDate_arrivee(rs.getDate("DATE_ARRIVEE"));
				chat.setDate_depart(rs.getDate("DATE_DEPART"));
				chat.setNom(rs.getString("NOM"));
				chat.setPelage(rs.getString("PELAGE"));
				chat.setRace(rs.getString("RACE"));
				chat.setSexe(rs.getString("SEXE").charAt(0));
				ProprietaireRepositoryImpl proprietaireRepo = new ProprietaireRepositoryImpl();
				chat.setProprietaire(proprietaireRepo.getById(rs.getShort("ID_PROPRIETAIRE")));
				liste_chats.add(chat);
			}

			System.out.println("Chats lus");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return liste_chats;
	}

	public void delete(Short id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(getById(id));
		System.out.println("Chat supprimé");
	}

}
