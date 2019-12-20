package org.sid.services;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.entities.Releve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceCompteImp  implements ServiceCompte{
	
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;

	@Override
	public List<Compte> FindAllComptes(String id) {
		// TODO Auto-generated method stub
		return compteRepository.findByIdAbonne(id);
	}

	@Override
	public List<Releve> ListDebitCredit(String  id) {
		List<Operation>debitcredit=operationRepository.findAll();
		List<Releve>debit =new ArrayList<Releve>();
		List<Releve>credit = new ArrayList<Releve>();
		List<Releve>AllRelevies = new ArrayList<Releve>();
		for (Operation operation : debitcredit) {
			if(operation.getIdCompteSrc()==id)
			{
				Releve re=new Releve(operation, "debit");
				debit.add(re);
			}
			if(operation.getIdCompteBeneficiaire()==id)
			{
				Releve re=new Releve(operation, "credit");
				credit.add(re);
			}
			AllRelevies.addAll(debit);
			AllRelevies.addAll(credit);
			
			
		}
		
		return AllRelevies;
	}


}
