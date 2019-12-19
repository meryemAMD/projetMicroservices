package com.exemple.services;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.AgenceRepository;
import com.example.repositories.BORepository;
import com.exemple.entities.Agence;
import com.exemple.entities.BO;

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
	public void deleteAgence(int id) {
		//delete all BOs related to this agence
		List<BO> bos=boRepository.findByIdAgence(id);
		boRepository.deleteAll(bos);
		agenceRepository.deleteById(id);
		
	}

	@Override
	public Agence FindByIdAgence(int id) {
		Optional<Agence> agence = this.agenceRepository.findById(id);
		if (agence.isPresent()) {
		    return agence.get();
		} else {
		    return null;
		}
		//return agencerepository.findOne(id);
	}

	@Override
	public List<Agence> FindAllAgences() {
		
		return agenceRepository.findAll();
	}

}
