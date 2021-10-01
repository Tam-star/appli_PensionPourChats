package com.tamstar.pensionchats.core.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.tamstar.pensionchats.core.DataSourceProvider;
import com.tamstar.pensionchats.core.entity.Proprietaire;

public class ProprietaireRepositoryImpl {

	public void create(Proprietaire proprietaire) {

		Connection conn = null;

		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(
					"INSERT INTO PROPRIETAIRE (NOM, PRENOM, TELEPHONE) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, proprietaire.getNom());
			preparedStatement.setString(2, proprietaire.getPrenom());
			preparedStatement.setString(3, proprietaire.getTelephone());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				proprietaire.setId(rs.getLong(1));
			}

			System.out.println("Propriétaire créé");

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

	public Proprietaire getById(Long id) {

		Connection conn = null;
		Proprietaire proprietaire = null;

		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM PROPRIETAIRE WHERE ID=?");
			preparedStatement.setLong(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				proprietaire = new Proprietaire();
				proprietaire.setId(id);
				proprietaire.setNom(rs.getString("NOM"));
				proprietaire.setPrenom(rs.getString("PRENOM"));
				proprietaire.setTelephone(rs.getString("TELEPHONE"));
			}

			System.out.println("Propriétaire lu");

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
				proprietaire.setId(rs.getLong("ID"));
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

	public void delete(Long id) {

		Connection conn = null;
		try {
			DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
			conn = dataSource.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM PROPRIETAIRE WHERE ID=?");
			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();

			System.out.println("Propriétaire supprimé");
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
