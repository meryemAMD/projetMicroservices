package org.sid.controllers;

import java.util.List;


import org.sid.entities.Compte;
import org.sid.entities.Releve;
//import org.sid.services.CompteServiceInt;
import org.sid.services.ServiceCompte;
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
	ServiceCompte serviceCompte;
	
	@RequestMapping(method = RequestMethod.GET, value = "/allComptes/{idAbonne}")
	public List<Compte> FindAllComptes(@PathVariable String idAbonne) {
		return serviceCompte.FindAllComptes(idAbonne);
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/DebitCredit/{idComptes}")
	public List<Releve> FindAllComptesDebitCredit(@PathVariable String idComptes) {
		return serviceCompte.ListDebitCredit(idComptes);
    }


}
