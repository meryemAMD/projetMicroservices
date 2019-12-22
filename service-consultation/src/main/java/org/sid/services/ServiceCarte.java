package org.sid.services;

import java.util.List;

import org.sid.entities.Carte;
import org.springframework.stereotype.Service;



@Service
public interface ServiceCarte {
	
	public  Carte saveCarte(Carte carte);
    public  Carte getCarte(String idCarte);
    public  Carte updateCarte(Carte carte);
    public  void deleteCarte(String id);
    public  List<Carte> getCartes(String id);
    public  void activateCarte(String id);
	public  void desactivateCarte(String id);
	public Carte findById(String id);

}
