package org.sid.dao;

import java.util.List;

import org.sid.entities.Abonne;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AbonneRepository extends MongoRepository<Abonne, Integer>{
	List<Abonne> findByIdBo(String idBo);
	List<Abonne> findByDomaine(String domaine);
	Abonne findByIdAbonne(String idAbonne);

}
