package org.sid.services;

import java.util.List;

import org.sid.entities.Offre;

public interface OffreServiceInt {

	List<Offre> findAll();

	Offre findById(String idOffre);

	void saveOrUpdateOffre(Offre offre);

	void deleteOffre(Offre offre, String idContrat);

	void updateOffre(Offre offre);

	void saveOffre(Offre offre, String idContrat);

}