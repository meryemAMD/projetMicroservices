package org.sid.controllers;

import java.util.List;

import org.sid.entities.Offre;
import org.sid.entities.Prelevement;
import org.sid.services.OffreService;
import org.sid.services.PrelevementServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Prelevement")
public class PrelevementController {
	@Autowired
	private PrelevementServiceInt prelevementService;
	
	@PostMapping(value = "/" , consumes = "application/json")
	public void save (@RequestBody Prelevement prelevement) {
		prelevementService.save(prelevement);
	}
}
