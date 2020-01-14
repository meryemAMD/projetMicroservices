package org.sid.dao;

import java.util.List;

import org.sid.entities.Beneficiaire;
import org.sid.entities.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OperationRepository extends MongoRepository<Operation, Integer>{
	Operation findByIdOperation(String idOperation);
	void deleteByIdOperation(String idOperation);
	List<Operation> findByIdCompteBeneficiaire(String idCompte);
	List<Operation> findByIdCompteSrc(String idCompte);
}