package org.sid.entities;

import java.io.Serializable;

public class BOCount implements Serializable{
	
	private String idAgence;

	private long total;

	public String getHosting() {
		return idAgence;
	}

	public void setHosting(String hosting) {
		this.idAgence = hosting;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	
	public BOCount(String hosting, long total) {
		super();
		this.idAgence = hosting;
		this.total = total;
	}

	public BOCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BOCount [hosting=" + idAgence + ", total=" + total + "]";
	}
	
	

}
