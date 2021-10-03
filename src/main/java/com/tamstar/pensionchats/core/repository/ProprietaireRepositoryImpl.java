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
import com.tamstar.pensionchats.core.entity.Proprietaire;

public class ProprietaireRepositoryImpl {

	public void create(Proprietaire proprietaire) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.persist(proprietaire);
		System.out.println("Propriétaire créé");

	}

	public Proprietaire getById(Short id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Proprietaire proprietaire = session.get(Proprietaire.class, id);
		return proprietaire;
	}

	public List<Proprietaire> getAllProprietaires() {

		Connection conn = null;
		List<Proprietaire> liste_proprietaires = new ArrayList<>();

		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM PROPRIETAIRE");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Proprietaire proprietaire = new Proprietaire();
				proprietaire.setId(rs.getShort("ID"));
				proprietaire.setNom(rs.getString("NOM"));
				proprietaire.setPrenom(rs.getString("PRENOM"));
				proprietaire.setTelephone(rs.getString("TELEPHONE"));
				liste_proprietaires.add(proprietaire);
			}

			System.out.println("Proprietaires lus");

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

		return liste_proprietaires;
	}

	public void delete(Short id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(getById(id));
		System.out.println("Propriétaire supprimé");

	}
}
