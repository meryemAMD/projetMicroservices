package org.sid.dao;

import java.util.List;

import org.sid.entities.Beneficiaire;
import org.sid.entities.Carte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarteRepository extends MongoRepository<Carte, Integer>{
	Carte findByIdCarte(String idCarte);
	void deleteByIdCarte(String idCarte);
	List<Carte> findByIdCompte(String idCompte);

}
