package org.sid.services;

import java.util.List;

import org.sid.dao.BeneficiaireRepository;
import org.sid.entities.Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaireService implements BeneficiaireServiceInt {
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;

	@Override
	public List<Beneficiaire> findByIdCompteSrc(String idCompteSrc) {
		// TODO Auto-generated method stub
		return beneficiaireRepository.findByIdCompteSrc(idCompteSrc);
	}

	@Override
	public Beneficiaire findById(String id) {
		// TODO Auto-generated method stub
		return beneficiaireRepository.findByIdBeneficiaire(id);
	}

	@Override
	public void update(Beneficiaire beneficiaire) {
		// TODO Auto-generated method stub
		beneficiaireRepository.save(beneficiaire);
	}

	@Override
	public void create(Beneficiaire beneficiaire , String idCompteSrc) {
		beneficiaire.setIdCompteSrc(idCompteSrc);
		beneficiaireRepository.save(beneficiaire);
	}

	@Override
	public List<Beneficiaire> findAll() {
		// TODO Auto-generated method stub
		return beneficiaireRepository.findAll();
	}

	@Override
	public void deleteBeneficiaire(Beneficiaire beneficiaire) {
		beneficiaireRepository.delete(beneficiaire);
	}

}
