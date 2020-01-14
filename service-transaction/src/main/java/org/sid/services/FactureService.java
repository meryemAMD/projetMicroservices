package org.sid.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.sid.dao.AbonneRepository;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;
import org.sid.proxies.FeignContratServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FactureService implements FactureServiceInt {
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
	@Autowired
	FeignContratServiceClient contratService;

	@Transactional
	@Override
	public Boolean createFacture(Operation operation, String idCompteSrc , String idAbonne) {
		int indicator = 0;
		operation.setIdCompteSrc(idCompteSrc);
		Compte compteSrc = compteRepository.findByIdCompte(idCompteSrc);
		Compte compteBene = compteRepository.findByIdAbonne(idAbonne).get(0);
		if(validateSolde(idCompteSrc, operation.getMontant())) {
			operation.setType("Paiement de facture");
			operation.setDate(new Date());
			//decrementer
			compteSrc.setSolde(compteSrc.getSolde() - operation.getMontant());
			//incrementer 
			compteBene.setSolde(compteBene.getSolde() + operation.getMontant());
			List<Compte> comptes = new ArrayList<>();
			comptes.add(compteSrc);
			comptes.add(compteBene);
			
			//save operation
			operationRepository.save(operation);
			indicator ++;
			compteRepository.saveAll(comptes);
			indicator ++;
			return true;
		}
		return false;
		
	}

	@Override
	public Boolean validerFacture(Operation vq) {
		Compte compteSrc = compteRepository.findByIdCompte(vq.getIdCompteSrc());	
		if(compteSrc.getSolde() - vq.getMontant()> 0) return true;
		return false;	
	}
	
	Boolean validateSolde(String idCompte , float montant) {
		if(compteRepository.findByIdCompte(idCompte).getSolde() - montant> 0) return true;
		return false;
	}

	@Override
	public List<Abonne> findEntreprises(String domaine) {
		//List<Abonne> abonnes = abonneRepository.findByDomaine(domaine);
		return contratService.findEntrepriseByDomaine(domaine);
	}

	
}
