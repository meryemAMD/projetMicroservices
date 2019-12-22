package org.sid.dao;

import org.sid.entities.Abonne;
import org.sid.entities.Agence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgenceRepository extends MongoRepository<Agence, Integer>{
	Agence findByIdAgence(String idAgence);
	void deleteByIdAgence(String idAgence);
}
