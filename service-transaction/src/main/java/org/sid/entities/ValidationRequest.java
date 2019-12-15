package org.sid.entities;

import java.io.Serializable;

public class ValidationRequest implements Serializable {
	private float montant;
	private String idBeneficiaire;
	private String idCompteSrc;
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getIdBeneficiaire() {
		return idBeneficiaire;
	}
	public void setIdBeneficiaire(String idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
	}
	public String getIdCompteSrc() {
		return idCompteSrc;
	}
	public void setIdCompteSrc(String idCompteSrc) {
		this.idCompteSrc = idCompteSrc;
	}
	
	

}
