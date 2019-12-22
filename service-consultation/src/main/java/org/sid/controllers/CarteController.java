package org.sid.controllers;

import java.util.List;
import org.sid.entities.Carte;
import org.sid.services.ServiceCarte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cartes")
public class CarteController {
	@Autowired
	ServiceCarte carteService;
	
	 //get carte by id
	 @RequestMapping(value="/{id}",method = RequestMethod.GET)
	    public Carte getCarte(@PathVariable String id){
	        return carteService.getCarte(id);
	    }
	 
	 @RequestMapping(value="/all/{id}",method = RequestMethod.GET)
	    public List<Carte> getCartes(@PathVariable String id){
		 
	        return carteService.getCartes(id);
	    }
	 @RequestMapping(value="/activate/{id}")
	    public void activateCarte(@PathVariable String id) {
	        carteService.activateCarte(id);
	    }
	 @RequestMapping(value="/desactivate/{id}")
	    public void desactivateCarte(@PathVariable String id) {
	        carteService.desactivateCarte(id);
	    }
	 @PostMapping(value = "/create" , consumes = "application/json")
		public void saveCarte(@RequestBody Carte carte) {
		    carteService.saveCarte(carte);
		}
		
		//
	 @PutMapping(value = "/update" , consumes = "application/json")
		public void updateCarte(@RequestBody Carte carte){
		   carteService.updateCarte(carte);
		}



}