package org.sid.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirementService implements VirementServiceInt {
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;

	@Override
	public Boolean create(Operation operation, String idCompteSrc) {
		int indicator = 0;
		operation.setIdCompteSrc(idCompteSrc);
		try {
			
			if(validateSolde(idCompteSrc, operation.getMontant())) {
				Compte compteSrc = compteRepository.findByIdCompte(idCompteSrc);
				Compte compteBene = compteRepository.findByIdCompte(operation.getIdCompteBeneficiaire());
				operation.setType(getTypeOperation(compteSrc , compteBene));
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

	private String getTypeOperation(Compte compteSrc, Compte compteBene) {
		if(compteSrc.getIdAbonne().equals(compteBene.getIdAbonne())) return "Virement interne";
		return "Virement externe";
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

}
