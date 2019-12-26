package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

public class ValidationResponse implements Serializable {
	
	private Beneficiaire beneficiaire;
	private Boolean etat;
	private String message;
	private String type;
	private float montant;
	private String idCompteSrc;
	
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getIdCompteSrc() {
		return idCompteSrc;
	}
	public void setIdCompteSrc(String idCompteSrc) {
		this.idCompteSrc = idCompteSrc;
	}

	
	
	

}
