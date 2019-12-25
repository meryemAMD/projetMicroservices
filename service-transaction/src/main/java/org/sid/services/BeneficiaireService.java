package org.sid.services;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.AbonneRepository;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.entities.Beneficiaire;
import org.sid.entities.Compte;
import org.sid.proxies.FeignContratServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaireService implements BeneficiaireServiceInt {
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
	@Autowired 
	CompteRepository compteRepository;
	
	@Autowired
	FeignContratServiceClient contratService;

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
	public void deleteBeneficiaire(String idBeneficiaire) {
		Beneficiaire b = new Beneficiaire();
		b.setIdBeneficiaire(idBeneficiaire);
		beneficiaireRepository.delete(b);
	}

	@Override
	public List<Beneficiaire> findByIdAbonne(String idAbonne) {
		//List<Compte> comptes = compteRepository.findByIdAbonne(idAbonne);//chercher les comptes de cet abonne
		List<Compte> comptes = contratService.findByIdAbonne(idAbonne);
		List<Beneficiaire> beneficiaires = new ArrayList<>(); 
		for (Compte compte : comptes) {//cherhcer les beneficiaires de chaque compte
			beneficiaires.addAll(beneficiaireRepository.findByIdCompteSrc(compte.getIdCompte()));
		}
		return beneficiaires;
	}

}
