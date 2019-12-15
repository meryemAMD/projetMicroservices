package org.sid.controllers;

import java.util.List;

import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;
import org.sid.services.VirementServiceInt;
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
@RequestMapping("/Virements")
public class VirementController {
	@Autowired
	private VirementServiceInt virementService;
	
	@PostMapping(value = "/{idCompteSrc}" , consumes = "application/json")
	public Boolean create(@RequestBody Operation operation , @PathVariable String idCompteSrc) {
			return virementService.create(operation , idCompteSrc);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/valider" , consumes = "application/json")
	public ValidationResponse valider(@RequestBody ValidationRequest validationRequest ) {
		return virementService.valider(validationRequest);
    }
	
	

}
