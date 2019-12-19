package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.dao.AbonneRepository;
import org.sid.dao.ContratRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratService implements ContratServiceInt{
	@Autowired
	private ContratRepository contratRepository;
	
	@Autowired
	private AbonneRepository abonneRepository;

	/* (non-Javadoc)
	 * @see org.sid.services.ContratServiceInt#findAll()
	 */
	@Override
	public List<Contrat> findAll() {
		// TODO Auto-generated method stub
		return contratRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.sid.services.ContratServiceInt#findById(java.lang.String)
	 */
	@Override
	public Contrat findById(String idContrat) {
		// TODO Auto-generated method stub
		return contratRepository.findByIdContrat(idContrat);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.ContratServiceInt#updateContrat(org.sid.entities.Contrat)
	 */
	@Override
	public void updateContrat(Contrat contrat) {
		contratRepository.save(contrat);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.ContratServiceInt#deleteContrat(org.sid.entities.Contrat)
	 */
	@Override
	public void deleteContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		contratRepository.delete(contrat);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.ContratServiceInt#createContrat(org.sid.entities.Contrat)
	 */
	@Override
	public void createContrat(Contrat contrat) {
		contratRepository.save(contrat);
	}

	@Override
	public Contrat findByAbonne(String idAbonne) {		
		return contratRepository.findByIdAbonne(idAbonne);
	}



}
