package org.sid.services;

import java.util.List;

import org.sid.entities.Carte;

public interface CarteServiceInt {

	List<Carte> findAll();

	Carte findById(String idCarte);

	void create(Carte carte, String idCarte);

	void deleteCarte(Carte carte);

	void update(Carte carte) throws Exception;

	List<Carte> findIdByCompte(String idCompte);

}