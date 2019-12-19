package com.exemple.services;

import java.util.List;

import com.exemple.entities.BO;


public interface BO_Service {
	
	public BO CreateBo(BO bo);	
	public BO  updateBo(BO bo);
	public  void deleteBo(int id);
	public BO FindByIdBo(int id);
	public List<BO> FindAllBo();

}
