package org.sid.services;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class FactureService implements FactureServiceInt {
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
	@Autowired
	AbonneRepository abonneRepository;

	@Override
	public Boolean createFacture(Operation operation, String idCompteSrc , String idAbonne) {
		int indicator = 0;
		operation.setIdCompteSrc(idCompteSrc);
		try {
			
			if(validateSolde(idCompteSrc, operation.getMontant())) {
				Compte compteSrc = compteRepository.findByIdCompte(idCompteSrc);
				Compte compteBene = compteRepository.findByIdAbonne(idAbonne).get(0);
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
		catch(Exception ex) {
			System.out.println("catching " + ex);
			if(indicator == 1) {
				operationRepository.delete(operation);
				return false;
			}
			else return false;
		}
	}

	@Override
	public ValidationResponse valider(ValidationRequest vq) {
		ValidationResponse vr = new ValidationResponse();
		if(validateSolde(vq.getIdCompteSrc(), vq.getMontant()) ){
			vr.setBeneficiaire(beneficiaireRepository.findByIdBeneficiaire(vq.getIdBeneficiaire()));
			vr.setEtat(true);
		}
		else {
			vr.setEtat(false);
		}
		return vr;
		
	}
	
	private Boolean validateSolde(String idCompte , float montant) {
		if(compteRepository.findByIdCompte(idCompte).getSolde() - montant> 0) return true;
		return false;
	}


	@Override
	public List<Abonne> findEntreprises(String domaine) {
		List<Abonne> abonnes = abonneRepository.findByDomaine(domaine);
		
		return abonnes;
	}

}
