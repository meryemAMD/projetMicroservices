package org.sid.services;

import java.util.List;

import org.sid.entities.BO;
import org.springframework.stereotype.Service;

@Service
public interface BO_Service {
	
	public BO CreateBo(BO bo);	
	public BO  updateBo(BO bo);
	
	public void deleteBo(String Bo);
	public BO getBO(String id);
	public List<BO> getBos();
	public List<BO>getBosByidAgences(String idAgence);
	public String FindIdBo_ByIdUser(String idUser);

}
