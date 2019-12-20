package org.sid.services;

import java.util.List;

import org.sid.entities.Agence;
import org.springframework.stereotype.Service;



@Service
public interface Agence_Service {
	
	public Agence CreateAgence(Agence agence);
	
	public Agence  updateAgence(Agence agence);
	public  void deleteAgence(String id);
	//public Agence FindByIdAgence(String id);
	public List<Agence> FindAllAgences();

	public Agence getAgence(String idAgence);
}
