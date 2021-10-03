package com.tamstar.pensionchats.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tamstar.pensionchats.core.DataSourceProvider;
import com.tamstar.pensionchats.core.HibernateUtil;
import com.tamstar.pensionchats.core.entity.Chat;

public class ChatRepositoryImpl {

	public void create(Chat chat) {

		Connection conn = null;

		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(
					"INSERT INTO CHAT (NOM, SEXE, RACE, PELAGE, AGE, DATE_ARRIVEE, DATE_DEPART, COMMENTAIRES, ID_PROPRIETAIRE) VALUES (?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, chat.getNom());
			preparedStatement.setString(2, chat.getSexe().toString());
			preparedStatement.setString(3, chat.getRace());
			preparedStatement.setString(4, chat.getPelage());
			preparedStatement.setInt(5, chat.getAge());
			preparedStatement.setDate(6, chat.getDate_arrivee());
			preparedStatement.setDate(7, chat.getDate_depart());
			preparedStatement.setString(8, chat.getCommentaires());
			preparedStatement.setLong(9, chat.getProprietaire().getId());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				chat.setId(rs.getShort(1));
			}

			System.out.println("Chat créé");

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

	}

	public Chat getById(Short id) {

		Chat chat = null;
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			chat = session.get(Chat.class, id);
			tx.commit();

			System.out.println("Chat lu");

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();

		} finally {
			if (session != null) {
				session.close();
			}

		}

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

	public void delete(Long id) {

		Connection conn = null;
		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM CHAT WHERE ID=?");
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();

			System.out.println("Chat supprimé");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
