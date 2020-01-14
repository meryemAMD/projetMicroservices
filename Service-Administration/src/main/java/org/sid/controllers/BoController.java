package org.sid.controllers;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.entities.BO;
import org.sid.services.BO_Service;
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
@RequestMapping("/Bos")
public class BoController {
	
	@Autowired
	BO_Service boService;
	
	/*1- FE will ask for abonne of specific idBo
	 * @RequestMapping(method = RequestMethod.GET, value = "byagence/{idAgence}")
	 * public List<BO> findByAgence(@PathVariable int idAgence) { return
	 * boService.FindByIdBo(idAgence); }
	 */
	
	//1- FE will ask for BO of specific idagence
	@RequestMapping(method = RequestMethod.GET, value = "byidAgence/{idAgence}")
	public List<BO> findByAgence(@PathVariable String idAgence){
		return boService.getBosByidAgences(idAgence);
	}
	
	//2- FE will ask for details about specific BO
	@GetMapping(value = "/byidBo/{idBo}")
	public BO findById(@PathVariable String idBo) {
		return boService.getBO(idBo);
    }
	
	//FE will ask for update (only attributes not dbref here we don't implement cascade saveorupdate)
	@PutMapping(value = "/update" , consumes = "application/json")
	public void update(@RequestBody BO bo) {
		boService.updateBo(bo);
	}
	
	//FE will ask for creating BO 
	@PostMapping(value = "/create" , consumes = "application/json")
	public void create(@RequestBody BO bo) {
			boService.CreateBo(bo);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/AllBos")
	public List<BO> findAll() {
		return boService.getBos();
    }
	
	@DeleteMapping(value = "/delete/{idBo}")
    public void deleteAbonne(@PathVariable String idBo) {
		boService.deleteBo(idBo);
    }
	//Ask Id Bo using Id User
	@RequestMapping(method = RequestMethod.GET, value = "/byidUser/{idUser}")
	public String findIdBo(@PathVariable String idUser){
		return boService.FindIdBo_ByIdUser(idUser);
	}

	


}
