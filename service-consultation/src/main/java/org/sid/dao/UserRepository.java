package org.sid.dao;

import org.sid.entities.Beneficiaire;
import org.sid.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, Integer>{
	User findByIdUser(String idUser);
	void deleteByIdUser(String idUser);

}
