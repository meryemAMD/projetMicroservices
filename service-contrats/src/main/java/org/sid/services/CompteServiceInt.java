package org.sid.services;

import java.util.List;

import org.sid.entities.Compte;

public interface CompteServiceInt {

	List<Compte> findAll();

	Compte findById(String idCompte);

	void create(Compte compte, String idAbonne);

	void deleteCompte(Compte compte);

	void update(Compte compte) throws Exception;

	List<Compte> findIdByAbonne(String idAbonne);

}