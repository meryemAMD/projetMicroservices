package org.sid.services;

import java.util.List;

import org.sid.entities.Offre;

public interface OffreServiceInt {

	List<Offre> findAll();

	Offre findById(String idOffre);

	void saveOrUpdateOffre(Offre offre);

	void deleteOffre(String idOffre, String idContrat);

	void updateOffre(Offre offre);

	void saveOffre(Offre offre, String idContrat);

	List<Offre> findByAbonne(String idAbonne);

	void saveOffreByIdAbonne(Offre offre, String idAbonne);

}