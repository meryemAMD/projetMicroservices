package org.sid.dao;

import org.sid.entities.BO;
import org.sid.entities.Beneficiaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BORepository extends MongoRepository<BO, Integer>{
	BO findByIdBo(String idBo);
	void deleteByIdBo(String idBo);
}
