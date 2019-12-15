package org.sid.entities;

import java.io.Serializable;

public class ValidationResponse implements Serializable {
	
	private Beneficiaire beneficiaire;
	private Boolean etat;
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
	
	

}
