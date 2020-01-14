package org.sid.entities;

import java.io.Serializable;

public class AbonneCount implements Serializable {
	
	
	private String idBo;

	private long total;
	
	public String getIdBo() {
		return idBo;
	}

	public void setIdBo(String idBo) {
		this.idBo = idBo;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "AbonneCount [idBo=" + idBo + ", total=" + total + "]";
	}

	public AbonneCount(String idBo, long total) {
		super();
		this.idBo = idBo;
		this.total = total;
	}

	public AbonneCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
