package org.sid.services;

import java.util.List;

import org.sid.entities.Abonne;

public interface AbonneServiceInt {

	List<Abonne> findAll();

	Abonne findById(String id);

	void create(Abonne abonne);

	void deleteAbonne(Abonne abonne);

	List<Abonne> findByBo(String idBo);

	void update(Abonne abonne) throws Exception;

}