package com.exemple.entities;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Agence {
	@Id
    private int idAgence;
	@Indexed(unique=true)
	private String label;
	private String adresse;
	private String tel;
	@DBRef
    private Collection<BO> bos;
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getidAgence() {
		return idAgence;
	}

	public void setidAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Collection<BO> getBos() {
		return bos;
	}

	public void setBos(Collection<BO> bos) {
		this.bos = bos;
	}
	
	
}
