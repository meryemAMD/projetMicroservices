package org.sid.dao;

import org.sid.entities.Abonne;
import org.sid.entities.Beneficiaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BeneficiaireRepository extends MongoRepository<Beneficiaire, Integer> {
	Beneficiaire findByIdBeneficiaire(String idBeneficiaire);
	void deleteByIdBeneficiaire(String idBeneficiaire);
}
