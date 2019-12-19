package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.repositories.AbonneRepository;
import com.example.repositories.AgenceRepository;
import com.example.repositories.BORepository;
import com.example.repositories.BeneficiaireRepository;
import com.example.repositories.CarteRepository;
import com.example.repositories.CompteRepository;
import com.example.repositories.ContratRepository;
import com.example.repositories.OffreRepository;
import com.example.repositories.OperationRepository;
import com.example.repositories.UserRepository;
import com.example.repositories.VirmentPermanentRepository;
import com.exemple.entities.Abonne;
import com.exemple.entities.Agence;
import com.exemple.entities.BO;
import com.exemple.entities.Beneficiaire;
import com.exemple.entities.Carte;
import com.exemple.entities.Compte;
import com.exemple.entities.Contrat;
import com.exemple.entities.Offre;
import com.exemple.entities.Operation;
import com.exemple.entities.VirmentPermanent;

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
			Stream.of(1 , 2).forEach(c->{
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
				abonnes.add(ab);
				
				Abonne ab1 = new Abonne();
				ab1.setIdAbonne(c+10);
				ab1.setNomComplet("complet"+c);
				ab1.setIdBo(c);
				abonnes.add(ab1);
				
				bo.setAbonnes(abonnes);
				agence.setBos(bos);

				
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
				
				cpt1.setCartes(crts);
				carteRepository.save(crt1);
				carteRepository.save(crt);
				//beneficiaire
				Beneficiaire b = new Beneficiaire();
				b.setIdBeneficiaire(c);
				beneficiaireRepository.save(b);
				//opertaion
				Operation op = new Operation();
				op.setIdOperation(c);
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
	
}
