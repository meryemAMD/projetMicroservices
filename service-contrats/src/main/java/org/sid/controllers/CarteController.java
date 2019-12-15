package org.sid.controllers;

import java.util.List;

import org.sid.entities.Carte;
import org.sid.services.CarteService;
import org.sid.services.CarteServiceInt;
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
	private CarteServiceInt carteService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Carte> findAll() {
		return carteService.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public Carte findById(@PathVariable String id) {
		return carteService.findById(id);
    }
	
	@GetMapping(value = "/{idCompte}")
	public List<Carte> findByIdCompte(@PathVariable String id) {
		return carteService.findIdByCompte(id);
    }
	
	@PutMapping(value = "/" , consumes = "application/json")
	public void update (@RequestBody Carte Carte) throws Exception {
		carteService.update(Carte);
	}

	@PostMapping(value = "/{idCompte}" , consumes = "application/json")
	public void save (@RequestBody Carte carte ,  @PathVariable String idCompte) {
		carteService.create(carte , idCompte);
	}

	@RequestMapping(value="/",method = RequestMethod.DELETE)
    public void deleteCarte(@RequestBody Carte carte) {
		carteService.deleteCarte(carte);
    }
	


}