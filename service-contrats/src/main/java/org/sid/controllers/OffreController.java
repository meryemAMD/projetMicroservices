package org.sid.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.sid.entities.Offre;
import org.sid.services.OffreServiceInt;
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
@RequestMapping("/Offres")
public class OffreController {

	@Autowired
	private OffreServiceInt offreService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<Offre> findAll() {
		return offreService.findAll();
    }
	
	@GetMapping(value = "/{id}")
	public Offre findById(@PathVariable String id) {
		return offreService.findById(id);
    }
	
	@GetMapping(value = "Abonne/{idAbonne}")
	public List<Offre> findByAbonne(@PathVariable String idAbonne) {
		return offreService.findByAbonne(idAbonne);
    }
	
	@PutMapping(value = "/" , consumes = "application/json")
	public void update (@RequestBody Offre Offre) {
		offreService.updateOffre(Offre);
	}

	@PostMapping(value = "Contrat/{idContrat}" , consumes = "application/json")
	public void save (@RequestBody Offre Offre ,  @PathVariable String idContrat) {
		offreService.saveOffre(Offre , idContrat);
	}
	
	@PostMapping(value = "Abonne/{idAbonne}" , consumes = "application/json")
	public void saveByIdAbonne (@RequestBody Offre offre ,  @PathVariable String idAbonne) {
		offreService.saveOffreByIdAbonne(offre, idAbonne);
	}

	@RequestMapping(value="/{idOffre}/{idContrat}",method = RequestMethod.DELETE)

    public void deleteOffre(@PathVariable String idOffre , @PathVariable String idContrat) {
		offreService.deleteOffre(idOffre , idContrat);
    }
	

}
