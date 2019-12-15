package org.sid.controllers;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.services.FactureServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Factures")
public class FactureController {
	@Autowired
	private FactureServiceInt factureService;
	
	
	@PostMapping(value = "payerFacture/{idCompteSrc}/{idAbonne}" , consumes = "application/json")
	public Boolean createFacture(@RequestBody Operation operation , @PathVariable String idCompteSrc , @PathVariable String idAbonne) {
			return factureService.createFacture(operation , idCompteSrc , idAbonne);
	}
	
	@GetMapping(value = "Entreprises/{domaine}")
	public List<Abonne> findEntreprises(@PathVariable String domaine) {
			return factureService.findEntreprises(domaine);
	}
}
