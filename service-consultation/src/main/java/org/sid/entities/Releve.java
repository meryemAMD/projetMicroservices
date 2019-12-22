package org.sid.entities;

import java.util.Date;

public class Releve extends Operation {

	private String debitCredit;

	public Releve(Operation operation , String debitCredit) {
		super(operation);
		this.debitCredit = debitCredit;
	}
	
	/*
	private String idOperation;
	private float montant;
	private Date date;
	private String type;
	private String numFacture;
	private String idCompteSrc;
	private String idCompteBeneficiaire;
	private String debitCredit;
	*/


}
