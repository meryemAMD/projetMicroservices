package org.sid.controllers;

import java.util.List;

import org.sid.entities.Contrat;
import org.sid.services.ContratServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/Contrats")
public class ContratController {

	@Autowired
	private ContratServiceInt contratService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Contrat> findAll() {
		return contratService.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public Contrat findById(@PathVariable String id) {
		return contratService.findById(id);
    }
	
	@GetMapping(value = "Abonne/{idAbonne}")
	public Contrat findByAbonne(@PathVariable String idAbonne) {
		return contratService.findByAbonne(idAbonne);
    }
	
	@PostMapping(value = "/" , consumes = "application/json")
	public void create (@RequestBody Contrat contrat) {
		contratService.createContrat(contrat);
	}
	
	@PutMapping(value = "/" , consumes = "application/json")
	public void update (@RequestBody Contrat contrat) {
		contratService.updateContrat(contrat);
	}

	
	@DeleteMapping(value = "/")
    public void deleteContrat(@RequestBody Contrat contrat) {
		contratService.deleteContrat(contrat);
    }
	

}
