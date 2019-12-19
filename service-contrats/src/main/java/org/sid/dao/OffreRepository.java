package org.sid.dao;

import java.util.List;

import org.sid.entities.Beneficiaire;
import org.sid.entities.Contrat;
import org.sid.entities.Offre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OffreRepository extends MongoRepository<Offre, Integer>{
	Offre findByIdOffre(String idOffre);
	Offre deleteByIdOffre(String idOffre);
	List<Offre> findByIdContrat(String idContrat);
}
