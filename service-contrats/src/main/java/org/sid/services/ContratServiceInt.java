package org.sid.services;

import java.util.List;

import org.sid.entities.Contrat;

public interface ContratServiceInt {

	List<Contrat> findAll();

	Contrat findById(String idContrat);

	void updateContrat(Contrat contrat);

	void deleteContrat(Contrat contrat);

	void createContrat(Contrat contrat);

}