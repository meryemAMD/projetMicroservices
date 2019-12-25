package org.sid.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.sid.dao.AbonneRepository;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.ContratRepository;
import org.sid.dao.OffreRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.sid.entities.Offre;
import org.sid.entities.Offre;
import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;
import org.sid.proxies.FeignContratServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VirementService implements VirementServiceInt {
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	BeneficiaireRepository beneficiaireRepository;
	
	@Autowired
	AbonneRepository abonneRepository;
	
	@Autowired
	FeignContratServiceClient contratService;
	
	@Transactional
	@Override
	public Boolean create(Operation operation, String idCompteSrc) {
		int indicator = 0;
		operation.setIdCompteSrc(idCompteSrc);
		try {
			Compte compteSrc = compteRepository.findByIdCompte(idCompteSrc);
			Compte compteBene = compteRepository.findByIdCompte(operation.getIdCompteBeneficiaire());
			if(validateSolde(idCompteSrc, operation.getMontant()) && validatePlafond(compteSrc , operation.getMontant() , getTypeOperation(compteSrc , compteBene))) {
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

	private boolean validatePlafond(Compte compteSrc, float montant, String type) {
		return contratService.validatePlafond(compteSrc.getIdAbonne(), montant, type);
		/*String idContrat = contratRepository.findByIdAbonne(compteSrc.getIdAbonne()).getIdContrat();
		List<Offre> offres = offreRepository.findByIdContrat(idContrat);
		Offre offre;
		for (Iterator<Offre> iterator = offres.iterator(); iterator.hasNext();) {
			offre = iterator.next();
	        if(offre.getType().equals(type)) {
	        	if(offre.getMax() > montant && offre.getMin() < montant ) {
	        		return true;
	        	}
	        }
	    }
		return false;*/
	}

	private String getTypeOperation(Compte compteSrc, Compte compteBene) {
		if(compteSrc.getIdAbonne().equals(compteBene.getIdAbonne())) return "Virement interne";
		return "Virement externe";
	}

	@Override
	public ValidationResponse valider(ValidationRequest vq) {
		System.out.println("i'm in");
		ValidationResponse vr = new ValidationResponse();
		Compte compteSrc = compteRepository.findByIdCompte(vq.getIdCompteSrc());
		String idCompteBeneficiaire = beneficiaireRepository.findByIdBeneficiaire(vq.getIdBeneficiaire()).getIdCompteBeneficiaire();
		Compte compteBene = compteRepository.findByIdCompte(idCompteBeneficiaire);	
		if(validateSolde(vq.getIdCompteSrc(), vq.getMontant()) && validatePlafond(compteSrc, vq.getMontant(), getTypeOperation(compteSrc, compteBene))){
			System.out.println("after if");
			vr.setBeneficiaire(beneficiaireRepository.findByIdBeneficiaire(vq.getIdBeneficiaire()));
			vr.setType(getTypeOperation(compteSrc, compteBene));
			vr.setIdCompteSrc(vq.getIdCompteSrc());
			vr.setMontant(vq.getMontant());
			vr.setEtat(true);
		}
		else {
			vr.setEtat(false);
			if(!(validateSolde(vq.getIdCompteSrc(), vq.getMontant()))) vr.setMessage("Votre solde est insuffisent!!");
			else vr.setMessage("Vous avez dépassé les plafonds!!");
		}
		System.out.println("Out ...");
		return vr;
	}
	
	private Boolean validateSolde(String idCompte , float montant) {
		if(compteRepository.findByIdCompte(idCompte).getSolde() - montant> 0) return true;
		return false;
	}

	public
	boolean testTransaction() {
		//operationRepository.CustomEmployeeMethod("f");
		System.out.println("after add");
		return true;
		
	}

}
