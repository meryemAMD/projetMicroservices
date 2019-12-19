package com.example.repositories;

import com.exemple.entities.Carte;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarteRepository extends MongoRepository<Carte, Integer>{

}
