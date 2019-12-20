package org.sid.controllers;

import java.util.List;

import org.sid.entities.Compte;
import org.sid.services.CompteServiceInt;
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
@RequestMapping("/Comptes")
public class CompteController {
	@Autowired
	private CompteServiceInt compteService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Compte> findAll() {
		return compteService.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public Compte findById(@PathVariable String id) {
		return compteService.findById(id);
    }
	
	@GetMapping(value = "Abonne/{idAbonne}")
	public List<Compte> findByIdAbonne(@PathVariable String idAbonne) {
		return compteService.findIdByAbonne(idAbonne);
    }
	
	@PutMapping(value = "/" , consumes = "application/json")
	public void update (@RequestBody Compte Compte) throws Exception {
		compteService.update(Compte);
	}

	@PostMapping(value = "/{idAbonne}" , consumes = "application/json")
	public void save (@RequestBody Compte compte ,  @PathVariable String idAbonne) {
		compteService.create(compte , idAbonne);
	}

	@RequestMapping(value="/",method = RequestMethod.DELETE)
    public void deleteCompte(@RequestBody Compte compte) {
		compteService.deleteCompte(compte);
    }
	


}
