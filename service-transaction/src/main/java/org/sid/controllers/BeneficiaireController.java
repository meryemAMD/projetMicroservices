package org.sid.controllers;

import java.util.List;

import org.sid.entities.Beneficiaire;
import org.sid.services.BeneficiaireServiceInt;
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
@RequestMapping("/Beneficiaires")
public class BeneficiaireController {

	
	@Autowired
	private BeneficiaireServiceInt beneficiaireService;
	
	
	//1- FE will ask for beneficiaire of specific idBo
	@RequestMapping(method = RequestMethod.GET, value = "byIdCompteSrc/{idCompteSrc}")
	public List<Beneficiaire> findByIdCompteSrc(@PathVariable String idCompteSrc) {
		return beneficiaireService.findByIdCompteSrc(idCompteSrc);
    }
	
	//2- FE will ask for details about specific beneficiaire
	@GetMapping(value = "/{id}")
	public Beneficiaire findById(@PathVariable String id) {
		return beneficiaireService.findById(id);
    }
	
	//FE will ask for update (only attributes not dbref here we don't implement cascade saveorupdate)
	@PutMapping(value = "/" , consumes = "application/json")
	public void update(@RequestBody Beneficiaire beneficiaire) throws Exception {
		beneficiaireService.update(beneficiaire);
	}
	
	//FE will ask for creating beneficiaire (here contract must be saved before)
	@PostMapping(value = "/{idCompteSrc}" , consumes = "application/json")
	public void create(@RequestBody Beneficiaire beneficiaire , @PathVariable String idCompteSrc) {
			beneficiaireService.create(beneficiaire , idCompteSrc);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Beneficiaire> findAll() {
		return beneficiaireService.findAll();
    }
	
	@DeleteMapping(value = "/")
    public void deleteBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
		beneficiaireService.deleteBeneficiaire(beneficiaire);
    }
	
}
