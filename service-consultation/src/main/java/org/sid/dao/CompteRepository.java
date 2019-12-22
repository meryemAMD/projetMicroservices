package org.sid.dao;

import java.util.List;

import org.sid.entities.Beneficiaire;
import org.sid.entities.Compte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteRepository extends MongoRepository<Compte, Integer> {

	List<Compte> findByIdAbonne(String idAbonne);

	//List<Compte> findByIdAbonne(int idAbonne);

	Compte findByIdCompte(String idCompte);
	void deleteByIdCompte(String idCompte);

}
