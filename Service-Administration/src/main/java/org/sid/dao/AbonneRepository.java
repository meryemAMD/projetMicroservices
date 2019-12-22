package org.sid.dao;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.entities.Contrat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AbonneRepository extends MongoRepository<Abonne, Integer>{
	@Query(value = "{ $and: [ { 'idBo' : ?0 }, { 'type' : ?1 } ] }")
	List<Abonne> findByIdBoAndType(String idBo , String type);
	List<Abonne> findByDomaine(String domaine);
	Abonne findByIdAbonne(String idAbonne);
	Abonne findByCin(String cin);

}
