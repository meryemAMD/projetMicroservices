package org.sid.entities;

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
	private String idCompte;
    private float solde;
    private String idAbonne;
    private String idBo;
    
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(String idCompte) {
		this.idCompte = idCompte;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public String getIdAbonne() {
		return idAbonne;
	}
	public void setIdAbonne(String idAbonne) {
		this.idAbonne = idAbonne;
	}

	public String getIdBo() {
		return idBo;
	}
	public void setIdBo(String idBo) {
		this.idBo = idBo;
	}
    
    
}
