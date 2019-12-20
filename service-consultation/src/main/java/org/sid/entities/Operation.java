package org.sid.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Operation {
	@Id
	private String idOperation;
	private float montant;
	private Date date;
	private String type;
	private String numFacture;
	private String idCompteSrc;
	private String idCompteBeneficiaire;
    
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(String idOperation) {
		this.idOperation = idOperation;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}

	public String getIdCompteSrc() {
		return idCompteSrc;
	}

	public void setIdCompteSrc(String idCompteSrc) {
		this.idCompteSrc = idCompteSrc;
	}

	public String getIdCompteBeneficiaire() {
		return idCompteBeneficiaire;
	}

	public void setIdCompteBeneficiaire(String idCompteBeneficiaire) {
		this.idCompteBeneficiaire = idCompteBeneficiaire;
	}

	public Operation(Operation operation) {
		super();
		this.idOperation = operation.idOperation;
		this.montant = operation.montant;
		this.date = operation.date;
		this.type = operation.type;
		this.numFacture = operation.numFacture;
		this.idCompteSrc = operation.idCompteSrc;
		this.idCompteBeneficiaire = operation.idCompteBeneficiaire;
	}

	public Operation(Prelevement prelevement) {
		super();
		this.montant = prelevement.getMontant();
		this.idCompteSrc = prelevement.getIdCompteSrc();
	}

    
	

}
