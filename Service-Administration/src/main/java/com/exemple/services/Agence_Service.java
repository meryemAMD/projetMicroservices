package com.exemple.services;

import java.util.List;


import com.exemple.entities.Agence;

public interface Agence_Service {
	
	public Agence CreateAgence(Agence agence);
	
	public Agence  updateAgence(Agence agence);
	public  void deleteAgence(int id);
	public Agence FindByIdAgence(int id);
	public List<Agence> FindAllAgences();
}
