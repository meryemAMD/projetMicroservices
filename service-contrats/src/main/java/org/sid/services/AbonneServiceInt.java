package org.sid.services;

import java.util.List;

import org.sid.entities.Abonne;

public interface AbonneServiceInt {

	List<Abonne> findAll();

	Abonne findById(String id);

	void createEntreprise(Abonne abonne);
	
	void createIndividu(Abonne abonne);

	void deleteAbonne(Abonne abonne);

	void update(Abonne abonne) throws Exception;

	List<Abonne> findByBo(String idBo, String type, int pageSize, int pageNum);

	void changeState(String idAbonne, boolean b);

	List<Abonne> findEntreprises(String domaine);


}