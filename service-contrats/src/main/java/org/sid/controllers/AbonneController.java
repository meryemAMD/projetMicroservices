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
	
	
	//1- FE will ask for abonne of specific idBo
	@RequestMapping(method = RequestMethod.GET, value = "byBo/{idBo}")
	public List<Abonne> findByBo(@PathVariable String idBo) {
		return abonneService.findByBo(idBo);
    }
	
	//2- FE will ask for details about specific abonne
	@GetMapping(value = "/{id}")
	public Abonne findById(@PathVariable String id) {
		return abonneService.findById(id);
    }
	
	//FE will ask for update (only attributes not dbref here we don't implement cascade saveorupdate)
	@PutMapping(value = "/" , consumes = "application/json")
	public void update(@RequestBody Abonne abonne) throws Exception {
		abonneService.update(abonne);
	}
	
	//FE will ask for creating abonne (here contract must be saved before)
	@PostMapping(value = "/" , consumes = "application/json")
	public void create(@RequestBody Abonne abonne) {
			abonneService.create(abonne);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Abonne> findAll() {
		return abonneService.findAll();
    }
	
	@DeleteMapping(value = "/")
    public void deleteAbonne(@RequestBody Abonne abonne) {
		abonneService.deleteAbonne(abonne);
    }
	

	/*@Autowired
	private AbonneClient abonneClient;
	
    public List<Abonne> getAllAbonnes() {
        return abonneClient.getAbonnes();
    }

    /*

    public ResponseEntity<?> saveOrUpdateAbonne(@RequestBody Abonne abonne) {
    	abonneClient.update(storeId, store);
        return new ResponseEntity("Abonne added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAbonne(@PathVariable int id) {
    	abonneClient.deleteAbonne(id);
    }
*/
}
