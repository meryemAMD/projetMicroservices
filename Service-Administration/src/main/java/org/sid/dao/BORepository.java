package org.sid.dao;

import java.util.List;


import org.sid.entities.BO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BORepository extends MongoRepository<BO, Integer>{
	BO findByIdBo(String idBo);
	void deleteByIdBo(String idBo);
	List<BO> findByIdAgence(String id);
	BO findByIdUser(String idUser);
	
	
}
