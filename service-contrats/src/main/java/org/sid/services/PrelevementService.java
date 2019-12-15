package org.sid.services;

import java.util.Date;

import org.sid.dao.AbonneRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Operation;
import org.sid.entities.Prelevement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrelevementService implements PrelevementServiceInt {

	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	AbonneRepository abonneRepository;
	
	@Autowired 
	OperationRepository operationRepository;

	
	/* (non-Javadoc)
	 * @see org.sid.services.PrelevementServiceInt#save(org.sid.entities.Prelevement)
	 */
	@Override
	public void save(Prelevement prelevement) {
		Operation operation = new Operation(prelevement);
		operation.setDate(new Date());
		operation.setType("Prélèvement");
		String idAbonne = abonneRepository.findByDomaine("Banque").get(0).getIdAbonne();
		String idCompteBeneficiaire = compteRepository.findByIdAbonne(idAbonne).get(0).getIdCompte();
		operation.setIdCompteBeneficiaire(idCompteBeneficiaire);
		operationRepository.save(operation);
	}

}
