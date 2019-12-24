package org.sid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.sid.dao.AbonneRepository;
import org.sid.dao.AgenceRepository;
import org.sid.dao.BORepository;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CarteRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.ContratRepository;
import org.sid.dao.OffreRepository;
import org.sid.dao.OperationRepository;
import org.sid.dao.ReleveRepository;
import org.sid.dao.UserRepository;
import org.sid.dao.VirmentPermanentRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Agence;
import org.sid.entities.BO;
import org.sid.entities.Beneficiaire;
import org.sid.entities.Carte;
import org.sid.entities.Compte;
import org.sid.entities.Contrat;
import org.sid.entities.Offre;
import org.sid.entities.Operation;
import org.sid.entities.VirmentPermanent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AbonneRepository abonneRepository , BORepository boRepository , CompteRepository compteRepository , 
			ContratRepository contratRepository , OffreRepository offreRepository
			,AgenceRepository agenceRepository , BeneficiaireRepository beneficiaireRepository , CarteRepository carteRepository,
			OperationRepository operationRepository , UserRepository userRepository , VirmentPermanentRepository virmentPermanentRepository
			,ReleveRepository releveRepository
			) {
	/*	compteRepository.deleteAll();
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
		releveRepository.deleteAll();*/
		return args->{
			/*Stream.of("ab" , "bc").forEach(c->{
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
				ab.setCin("HH"+c);
				abonnes.add(ab);
				
				Abonne ab1 = new Abonne();
				ab1.setIdAbonne(c+10);
				ab1.setNomComplet("complet"+c);
				ab1.setCin("HH"+c+"A");
				ab1.setIdBo(c);
				abonnes.add(ab1);
				
				bo.setAbonnes(abonnes);


				
				Contrat contrat = new Contrat();
				contrat.setIdContrat(c); contrat.setIdAbonne(c);

				
				Offre offre1 = new Offre();
				offre1.setIdContrat(c); offre1.setIdOffre(c);
				Offre offre2 = new Offre();
				offre2.setIdContrat(c); offre2.setIdOffre(c+10);
				List<Offre> offres = new ArrayList<>();
				offres.add(offre1);
				offres.add(offre2);

				
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
				op.setIdCompteBeneficiaire(cpt1.getIdCompte());
				operationRepository.save(op);
				Operation op1 = new Operation();
				op1.setIdCompteBeneficiaire(cpt2.getIdCompte());
				op1.setIdCompteSrc(cpt1.getIdCompte());
				operationRepository.save(op1);
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
			carteRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});
			
			compteRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});
			operationRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});
			releveRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});*/
			
		
			
		};
	}
	
}
