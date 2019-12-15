package org.sid.services;

import java.util.List;

import org.sid.entities.Beneficiaire;

public interface BeneficiaireServiceInt {

	List<Beneficiaire> findByIdCompteSrc(String idCompteSrc);

	Beneficiaire findById(String id);

	void update(Beneficiaire beneficiaire);

	void create(Beneficiaire beneficiaire, String idCompteSrc);

	List<Beneficiaire> findAll();

	void deleteBeneficiaire(Beneficiaire beneficiaire);

}
