package org.sid.services;

import java.util.List;

import org.sid.entities.Compte;
import org.sid.entities.Releve;
import org.springframework.stereotype.Service;

//import com.exemple.entities.Compte;

@Service
public interface ServiceCompte {
	
	//public List<Compte> FindAllComptes();

	public List<Compte> FindAllComptes(String id);
	public List<Releve> ListDebitCredit(String id);
	

}
