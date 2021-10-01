package com.tamstar.pensionchats.core.service;

import java.util.List;

import com.tamstar.pensionchats.core.entity.Proprietaire;
import com.tamstar.pensionchats.core.repository.ProprietaireRepositoryImpl;

public class ProprietaireService {

	private ProprietaireRepositoryImpl proprietaireRepository;

	public ProprietaireService() {
		this.proprietaireRepository = new ProprietaireRepositoryImpl();
	}

	public void creerProprietaire(Proprietaire proprietaire) {
		proprietaireRepository.create(proprietaire);
	}

	public Proprietaire getProprietaire(Long id) {
		return proprietaireRepository.getById(id);
	}

	public List<Proprietaire> getListProprietaires() {
		return proprietaireRepository.getAllProprietaires();
	}

	public void supprimerChat(Long id) {
		proprietaireRepository.delete(id);
	}
}
