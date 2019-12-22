package org.sid.dao;

import org.sid.entities.Beneficiaire;
import org.sid.entities.VirmentPermanent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VirmentPermanentRepository extends MongoRepository<VirmentPermanent, Integer>{
	VirmentPermanent findByIdVirment(String idVirment);
	void deleteByIdVirment(String idVirment);

}
