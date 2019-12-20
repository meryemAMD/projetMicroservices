package org.sid.dao;

import org.sid.entities.Releve;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReleveRepository extends MongoRepository<Releve, Integer> {

}
