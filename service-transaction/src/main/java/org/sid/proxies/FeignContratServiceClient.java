package org.sid.proxies;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("abonne")
//@RibbonClient(name = "abonne" , configuration = RibbonConfiguration.class)
@FeignClient(name="contrat-service", configuration=FeignConfiguration.class)
public interface FeignContratServiceClient {
	
	@GetMapping(value = "/Comptes/Abonne/{idAbonne}")
	public List<Compte> findByIdAbonne(@PathVariable String idAbonne);
	
	@GetMapping(value = "/Abonnes/Entreprises/{domaine}")
	public List<Abonne> findEntrepriseByDomaine(@PathVariable String domaine) ;
	
	@RequestMapping(value="/Offres/{idAbonne}/{montant}/{type}",method = RequestMethod.POST)
    public Boolean validatePlafond(@PathVariable String idAbonne , @PathVariable float montant , @PathVariable String type );
	
}
