package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.repositories.AbonneRepository;
import com.example.repositories.AgenceRepository;
import com.example.repositories.BORepository;
import com.exemple.entities.Abonne;
import com.exemple.entities.Agence;
import com.exemple.entities.BO;

@SpringBootApplication//(scanBasePackages={"com.example.something", "com.example.application"})
@EnableMongoRepositories(basePackageClasses = AgenceRepository.class)
public class ServiceAdministrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAdministrationApplication.class, args);
	}
	@Bean 
	CommandLineRunner start(AgenceRepository agenceRepository,BORepository boRepository,AbonneRepository aboneeRepository) {
		agenceRepository.deleteAll();
		boRepository.deleteAll();
		aboneeRepository.deleteAll();
		return args->{
			Stream.of(1,2,3).forEach(cn->{
				Agence agence = new Agence();
				agence.setLabel("testAgence"+cn); agence.setidAgence(cn);
				agenceRepository.save(agence);
				
				BO bo = new BO();
				bo.setCin("CIN: 12546"+cn);
				bo.setIdAgence(agence.getidAgence());
				bo.setIdBo(cn);
				boRepository.save(bo);
				
				List<Abonne> abonnes = new ArrayList<>();
				Abonne ab = new Abonne();
				ab.setIdAbonne(cn);
				ab.setNom("nom Abonee"+cn);
				ab.setIdBo(cn);
				//abonnes.add(ab);
				
				//bo.setAbonnes(abonnes);
				
				
			});
			//companyRepository.findAll().forEach(System.out::println);
			agenceRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});
			
			boRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});
			aboneeRepository.findAll().forEach(s->{
				System.out.println(s.toString());//exp Lamda
			});
		};
		
	
	}

}
