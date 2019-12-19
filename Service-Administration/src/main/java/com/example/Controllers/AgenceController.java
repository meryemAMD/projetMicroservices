package com.example.Controllers;

import java.util.List;



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

import com.exemple.entities.Agence;
import com.exemple.services.Agence_Service;

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
	@DeleteMapping(value = "/{id}")
    public void deleteAbonne(@PathVariable int id) {
		agenceService.deleteAgence(id);
    }
	
	//
	@GetMapping(value = "/{id}")
	public Agence findById(@PathVariable int id) {
		return agenceService.FindByIdAgence(id);
    }
	
	//
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Agence> findAll() {
		return agenceService.FindAllAgences();
    }
	
	
	
	
	
	

}
