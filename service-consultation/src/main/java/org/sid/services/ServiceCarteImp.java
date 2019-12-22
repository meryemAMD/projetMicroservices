package org.sid.services;

import java.util.List;


import java.util.Optional;

import org.sid.dao.CarteRepository;
import org.sid.entities.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceCarteImp  implements ServiceCarte{
	
	@Autowired
	CarteRepository carteRepository;

	@Override
	public Carte saveCarte(Carte carte) {
		// TODO Auto-generated method stub
		return carteRepository.save(carte);
	}

	@Override
	public Carte getCarte(String idCarte) {
		// TODO Auto-generated method stub
		return this.carteRepository.findByIdCarte(idCarte);
		
		//return carteRepository.findOne(id);
	}

	@Override
	public Carte updateCarte(Carte carte) {
		// TODO Auto-generated method stub
		return carteRepository.save(carte);
	}

	@Override
	public void deleteCarte(String id) {
		// TODO Auto-generated method stub
		carteRepository.deleteByIdCarte(id);
	}

	@Override
	public List<Carte> getCartes(String id) {
		// TODO Auto-generated method stub
		return carteRepository.findByIdCompte(id);
	}

	//enable carte
	@Override
	public void activateCarte(String id) {
		// TODO Auto-generated method stub
		//Abonne abonne=carteRepository.findById(id)
		Carte carte=getCarte(id);
		carte.setIsActivate(true);
		//carte.setActivate(true);
		carteRepository.save(carte);
		
	}
	
	//disable carte
	@Override
	public void desactivateCarte(String id) {
		// TODO Auto-generated method stub
		Carte carte=getCarte(id);
		carte.setIsActivate(false);
		carteRepository.save(carte);
	}

	@Override
	public Carte findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
