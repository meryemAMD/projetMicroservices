package org.sid.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Offre {
	@Id
    private String idOffre;
	private int min;
	private int max;
	private String type;
    private  String  idContrat;
    
	public Offre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(String idOffre) {
		this.idOffre = idOffre;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(String idContrat) {
		this.idContrat = idContrat;
	}
    
    
}
