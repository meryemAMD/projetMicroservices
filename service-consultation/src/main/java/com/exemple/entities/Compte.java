package com.exemple.entities;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor 
public class Compte {
	@Id
	private int idCompte;
    private float solde;
    private int idAbonne;
    @DBRef
    private Collection<Carte> cartes;
    
    
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public int getIdAbonne() {
		return idAbonne;
	}
	public void setIdAbonne(int idAbonne) {
		this.idAbonne = idAbonne;
	}
	public Collection<Carte> getCartes() {
		return cartes;
	}
	public void setCartes(Collection<Carte> cartes) {
		this.cartes = cartes;
	}
    
    
}
