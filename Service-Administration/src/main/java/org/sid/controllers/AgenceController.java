package org.sid.controllers;

import java.util.List;

import org.sid.entities.Agence;
import org.sid.services.Agence_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value = "/Agences")
@CrossOrigin
public class AgenceController {
	
	@Autowired
	Agence_Service agenceService;

	//
	@PostMapping(value = "/create" , consumes = "application/json")
	public void create(@RequestBody Agence agence) {
			agenceService.CreateAgence(agence);
	}
	
	//
	@PutMapping(value = "/update" , consumes = "application/json")
	public void update(@RequestBody Agence agence){
		agenceService.updateAgence(agence);
	}
	

	//
	@DeleteMapping(value = "/{idAgence}")
    public void deleteAbonne(@PathVariable String idAgence) {
		agenceService.deleteAgence(idAgence);
    }
	
	//
	@GetMapping(value = "/{idAgence}")
	public Agence findAgenceById(@PathVariable String idAgence) {
		return agenceService.getAgence(idAgence);
    }
	
	//
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Agence> findAllAgences() {
		return agenceService.FindAllAgences();
    }
	
	
	
	
	
	

}
