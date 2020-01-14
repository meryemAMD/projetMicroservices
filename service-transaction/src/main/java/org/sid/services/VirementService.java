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
import org.sid.dao.OperationRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Beneficiaire;
import org.sid.entities.Compte;
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
		Compte compteSrc = compteRepository.findByIdCompte(idCompteSrc);
		Compte compteBene = compteRepository.findByIdCompte(operation.getIdCompteBeneficiaire());
		if (validateSolde(idCompteSrc, operation.getMontant()) && validatePlafond(compteSrc.getIdAbonne(),
				operation.getMontant(), getTypeOperation(compteSrc, compteBene))) {
			operation.setDate(new Date());
			// decrementer
			compteSrc.setSolde(compteSrc.getSolde() - operation.getMontant());
			// incrementer
			compteBene.setSolde(compteBene.getSolde() + operation.getMontant());
			List<Compte> comptes = new ArrayList<>();
			comptes.add(compteSrc);
			comptes.add(compteBene);

			// save operation
			operationRepository.save(operation);
			indicator++;
			compteRepository.saveAll(comptes);
			indicator++;
			return true;
		}
		return false;

	}

	String getTypeOperation(Compte compteSrc, Compte compteBene) {
		if (compteSrc.getIdAbonne().equals(compteBene.getIdAbonne()))
			return "Virement interne";
		return "Virement externe";
	}

	@Override
	public ValidationResponse valider(ValidationRequest vq) {
		ValidationResponse vr = new ValidationResponse();
		Compte compteSrc = compteRepository.findByIdCompte(vq.getIdCompteSrc());
		Beneficiaire beneficiaire = beneficiaireRepository.findByIdBeneficiaire(vq.getIdBeneficiaire());
		String idCompteBeneficiaire = beneficiaire.getIdCompteBeneficiaire();
		Compte compteBene = compteRepository.findByIdCompte(idCompteBeneficiaire);
		String type = getTypeOperation(compteSrc, compteBene);

		Boolean soldeValide = validateSolde(vq.getIdCompteSrc(), vq.getMontant());

		Boolean plafondValide = validatePlafond(compteSrc.getIdAbonne(), vq.getMontant(), type);

		if (soldeValide && plafondValide) {
			vr.setBeneficiaire(beneficiaire);
			vr.setType(type);
			vr.setIdCompteSrc(vq.getIdCompteSrc());
			vr.setMontant(vq.getMontant());
			vr.setEtat(true);
		} else {
			// si il n'a pas l'offfre il va setmessae "vous ne disposer pas if(idabonne -> )
			vr.setEtat(false);
			if (!(validateSolde(vq.getIdCompteSrc(), vq.getMontant())))
				vr.setMessage("Votre solde est insuffisent!!");
			else
				vr.setMessage("Vous avez dépassé les plafonds!!");
		}
		return vr;
	}

	Boolean validateSolde(String idCompte, float montant) {
		if (compteRepository.findByIdCompte(idCompte).getSolde() - montant > 0)
			return true;
		return false;
	}

	Boolean validatePlafond(String idAbonne, float montant, String type) {
		return contratService.validatePlafond(idAbonne, montant, type);
	}

}
