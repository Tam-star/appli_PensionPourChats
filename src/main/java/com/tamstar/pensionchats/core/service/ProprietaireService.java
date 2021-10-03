package com.tamstar.pensionchats.core.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tamstar.pensionchats.core.HibernateUtil;
import com.tamstar.pensionchats.core.entity.Proprietaire;
import com.tamstar.pensionchats.core.repository.ProprietaireRepositoryImpl;

public class ProprietaireService {

	private ProprietaireRepositoryImpl proprietaireRepository;

	public ProprietaireService() {
		this.proprietaireRepository = new ProprietaireRepositoryImpl();
	}

	public void creerProprietaire(Proprietaire proprietaire) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			proprietaireRepository.create(proprietaire);
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

	public Proprietaire getProprietaire(Short id) {
		Session session = null;
		Transaction tx = null;
		Proprietaire proprietaire = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			proprietaire = proprietaireRepository.getById(id);
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
		return proprietaire;
	}

	public List<Proprietaire> getListProprietaires() {
		return proprietaireRepository.getAllProprietaires();
	}

	public void supprimerProprietaire(Short id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			proprietaireRepository.delete(id);
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
