package org.sid.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Beneficiaire {
	@Id
	private String idBeneficiaire;
	private String idCompteBeneficiaire;
	private String idCompteSrc;
	private String username;
	
	
	
	public Beneficiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdBeneficiaire() {
		return idBeneficiaire;
	}
	public void setIdBeneficiaire(String idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
	}
	public String getIdCompteBeneficiaire() {
		return idCompteBeneficiaire;
	}
	public void setIdCompteBeneficiaire(String idCompteBeneficiaire) {
		this.idCompteBeneficiaire = idCompteBeneficiaire;
	}
	public String getIdCompteSrc() {
		return idCompteSrc;
	}
	public void setIdCompteSrc(String idCompteSrc) {
		this.idCompteSrc = idCompteSrc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	

}
