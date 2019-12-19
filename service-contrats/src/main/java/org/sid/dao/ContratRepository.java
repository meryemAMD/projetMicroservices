package org.sid.dao;

import org.sid.entities.Beneficiaire;
import org.sid.entities.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContratRepository extends MongoRepository<Contrat, Integer>{
	Contrat findByIdContrat(String idContrat);
	void deleteByIdContrat(String idContrat);
	Contrat findByIdAbonne(String idAbonne);

}
