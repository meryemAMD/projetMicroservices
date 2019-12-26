package org.sid.controllers;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.proxies.AbonneClient;
import org.sid.services.AbonneServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Abonnes")
public class AbonneController {
	
	
	@Autowired
	private AbonneServiceInt abonneService;

	@RequestMapping(method = RequestMethod.GET, value = "Individu/{idBo}/{pageSize}/{pageNum}")
	public List<Abonne> findByBoIndividu(@PathVariable String idBo , @PathVariable int pageSize , @PathVariable int pageNum ) {
		return abonneService.findByBo(idBo , "individu" , pageSize , pageNum);
    }

	@RequestMapping(method = RequestMethod.GET, value = "Entreprise/{idBo}/{pageSize}/{pageNum}")
	public List<Abonne> findByBoEntreprise(@PathVariable String idBo , @PathVariable int pageSize , @PathVariable int pageNum ) {
		return abonneService.findByBo(idBo , "entreprise" , pageSize , pageNum);
    }

	@GetMapping(value = "/{id}")
	public Abonne findById(@PathVariable String id) {
		System.out.println("hello");
		return abonneService.findById(id);
    }
	
	@GetMapping(value = "/Entreprises/{domaine}")
	public List<Abonne> findEntrepriseByDomaine(@PathVariable String domaine) {
		return abonneService.findEntreprises(domaine);
    }

	@PutMapping(value = "/" , consumes = "application/json")
	public void update(@RequestBody Abonne abonne) throws Exception {
		abonneService.update(abonne);
	}

	@PostMapping(value = "Individu/" , consumes = "application/json")
	public void createIndividu(@RequestBody Abonne abonne) {
			abonneService.createIndividu(abonne);
	}
	
	//FE will ask for creating abonne (here contract must be saved before)
	@PostMapping(value = "Entreprise/" , consumes = "application/json")
	public void createEntreprise(@RequestBody Abonne abonne) {
			abonneService.createEntreprise(abonne);
	}
	
	//FE will ask for creating abonne (here contract must be saved before)
	@PostMapping(value = "activer/{idAbonne}" , consumes = "application/json")
	public void changeStateTotrue(@PathVariable String idAbonne) {
			abonneService.changeState(idAbonne , true);
	}
	
	//FE will ask for creating abonne (here contract must be saved before)
	@PostMapping(value = "desactiver/{idAbonne}" , consumes = "application/json")
	public void changeStateToFalse(@PathVariable String idAbonne) {
			abonneService.changeState(idAbonne , false);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Abonne> findAll() {
		return abonneService.findAll();
    }
	
	@DeleteMapping(value = "/")
    public void deleteAbonne(@RequestBody Abonne abonne) {
		abonneService.deleteAbonne(abonne);
    }
	
}
