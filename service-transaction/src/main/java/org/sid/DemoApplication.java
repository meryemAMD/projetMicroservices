package org.sid;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*
	@RestController
	class ZipkinController{
	     
	    @Autowired
	    RestTemplate restTemplate;
	 
	    @Bean
	    public RestTemplate getRestTemplate() {
	        return new RestTemplate();
	    }
	 
	 
	    private final Logger LOG = Logger.getLogger(ZipkinController.class.getName());
	     
	    @GetMapping(value="/zipkin")
	    public String zipkinService1() 
	    {
	        LOG.info("Inside zipkinService 1..");
	         
	        // String response = (String) restTemplate.exchange("http://localhost:8082/zipkin2", 
	                       // HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
	        return "Hi...";
	    }
	}
/*
	@Bean
	CommandLineRunner start(AbonneRepository abonneRepository , BORepository boRepository , CompteRepository compteRepository , 
			ContratRepository contratRepository , OffreRepository offreRepository
			,AgenceRepository agenceRepository , BeneficiaireRepository beneficiaireRepository , CarteRepository carteRepository,
			OperationRepository operationRepository , UserRepository userRepository , VirmentPermanentRepository virmentPermanentRepository
			) {
		compteRepository.deleteAll();
		contratRepository.deleteAll();
		agenceRepository.deleteAll();
		beneficiaireRepository.deleteAll();
		carteRepository.deleteAll();
		operationRepository.deleteAll();
		userRepository.deleteAll();
		abonneRepository.deleteAll();
		boRepository.deleteAll();
		offreRepository.deleteAll();
		virmentPermanentRepository.deleteAll();
		return args->{
			Stream.of("ab" , "bc").forEach(c->{
				List<BO> bos = new ArrayList<>();
				List<Abonne> abonnes = new ArrayList<>();
				
				Agence agence = new Agence();
				agence.setLabel("testAgence"+c); agence.setidAgence(c);
				
				BO bo = new BO();
				bo.setIdBo(c); bo.setNom("test1-"+c);
				bos.add(bo);
				
				BO bo1 = new BO();
				bo1.setIdBo(c+10); bo1.setNom("test2"+c);
				bos.add(bo1);
				
				Abonne ab = new Abonne();
				ab.setIdAbonne(c);
				ab.setNom("nom");
				ab.setIdBo(c);
				ab.setDomaine("Banque");
				abonnes.add(ab);
				
				Abonne ab1 = new Abonne();
				ab1.setIdAbonne(c+10);
				ab1.setNomComplet("complet"+c);
				ab1.setIdBo(c);
				abonnes.add(ab1);
				
				bo.setAbonnes(abonnes);


				
				Contrat contrat = new Contrat();
				contrat.setIdContrat(c); contrat.setIdAbonne(c);
				ab.setContrat(contrat);
				
				Offre offre1 = new Offre();
				offre1.setIdContrat(c); offre1.setIdOffre(c);
				Offre offre2 = new Offre();
				offre2.setIdContrat(c); offre2.setIdOffre(c+10);
				List<Offre> offres = new ArrayList<>();
				offres.add(offre1);
				offres.add(offre2);
				contrat.setOffres(offres);
				
				//compte
				Compte cpt1 = new Compte();
				cpt1.setIdCompte(c); cpt1.setIdAbonne(c);
				compteRepository.save(cpt1);
				Compte cpt2 = new Compte();
				cpt2.setIdCompte(c+10); cpt2.setIdAbonne(c);
				compteRepository.save(cpt2);
				//carte
				Carte crt = new Carte();
				crt.setIdCarte(c); crt.setIdCompte(c);

				Carte crt1 = new Carte();
				crt1.setIdCarte(c+10); crt.setIdCompte(c);

				List<Carte> crts = new ArrayList<>();
				crts.add(crt); crts.add(crt1);
				

				carteRepository.save(crt1);
				carteRepository.save(crt);
				//beneficiaire
				Beneficiaire b = new Beneficiaire();
				beneficiaireRepository.save(b);
				//opertaion
				Operation op = new Operation();
				operationRepository.save(op);
				//virment permanent
				VirmentPermanent vp = new VirmentPermanent();
				vp.setIdVirment(c);
				virmentPermanentRepository.save(vp);
				
				
				contratRepository.save(contrat);
				offreRepository.save(offre1);
				offreRepository.save(offre2);
				boRepository.save(bo);
				boRepository.save(bo1);
				agenceRepository.save(agence);
				abonneRepository.save(ab);
				abonneRepository.save(ab1);
				
				
				
			});	
		};
	}
	*/
}
