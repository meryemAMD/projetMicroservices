package org.sid.services;

import java.util.List;


import java.util.Optional;

import org.sid.dao.AgenceRepository;
import org.sid.dao.BORepository;
import org.sid.entities.Agence;
import org.sid.entities.BO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Agence_ServiceImp  implements Agence_Service{
	
	@Autowired
	private AgenceRepository agenceRepository;
	
	@Autowired
	BORepository boRepository;

	@Override
	public Agence CreateAgence(Agence agence) {
		
		return agenceRepository.save(agence);
	}

	@Override
	public Agence updateAgence(Agence agence) {
		
		return agenceRepository.save(agence);
	}

	@Override
	public void deleteAgence(String id) {
		//delete all BOs related to this agence
		List<BO> bos=boRepository.findByIdAgence(id);
		boRepository.deleteAll(bos);
		agenceRepository.deleteByIdAgence(id);
		
	}

	@Override
	public Agence getAgence(String idAgence) {
		Agence agence = this.agenceRepository.findByIdAgence(idAgence);
		return agence;
		//return agencerepository.findOne(id);
	}

	@Override
	public List<Agence> FindAllAgences() {
		
		return agenceRepository.findAll();
	}

}
