package com.example.Controllers;

import java.util.List;

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

import com.exemple.entities.Abonne;
import com.exemple.entities.BO;
import com.exemple.services.BO_Service;

@RestController
@RequestMapping("/Bos")
public class BoController {
	
	@Autowired
	BO_Service boService;
	
	/*1- FE will ask for abonne of specific idBo
	 * @RequestMapping(method = RequestMethod.GET, value = "byagence/{idAgence}")
	 * public List<BO> findByAgence(@PathVariable int idAgence) { return
	 * boService.FindByIdBo(idAgence); }
	 */
	//ask for Abonne of a spicific idBo
	@RequestMapping(method = RequestMethod.GET, value = "byBo/{idBO}")
	public List<Abonne> findByBo(@PathVariable int idbo){
		return ((BoController) boService).findByBo(idbo);
	}
	//1- FE will ask for BO of specific idagence
	@RequestMapping(method = RequestMethod.GET, value = "byagence/{idAgence}")
	public List<BO> findByAgence(@PathVariable int idAgence){
		return ((BoController) boService).findByAgence(idAgence);
	}
	
	//2- FE will ask for details about specific BO
	@GetMapping(value = "/{id}")
	public BO findById(@PathVariable int id) {
		return boService.FindByIdBo(id);
    }
	
	//FE will ask for update (only attributes not dbref here we don't implement cascade saveorupdate)
	@PutMapping(value = "/" , consumes = "application/json")
	public void update(@RequestBody BO bo) {
		boService.updateBo(bo);
	}
	
	//FE will ask for creating BO 
	@PostMapping(value = "/" , consumes = "application/json")
	public void create(@RequestBody BO bo) {
			boService.CreateBo(bo);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public List<BO> findAll() {
		return boService.FindAllBo();
    }
	
	@DeleteMapping(value = "/{id}")
    public void deleteAbonne(@PathVariable int id) {
		boService.deleteBo(id);
    }
	

	


}
