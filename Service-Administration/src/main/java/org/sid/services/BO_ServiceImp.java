package org.sid.services;

import java.util.List;

import java.util.Optional;

import org.sid.dao.AbonneRepository;
import org.sid.dao.BORepository;
import org.sid.entities.BO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BO_ServiceImp  implements BO_Service{
	
	@Autowired
	BORepository boRepository;
	@Autowired
	AbonneRepository aboneeRepository;
	

	@Override
	public BO CreateBo(BO bo) {
		
		return boRepository.save(bo);
	}

	@Override
	public BO updateBo(BO bo) {
		
		return boRepository.save(bo);
	}

	@Override
	public void deleteBo(String idBo) {
		boRepository.deleteByIdBo(idBo);
		
	}

	@Override
	public BO getBO(String idBo) {
		return boRepository.findByIdBo(idBo);
	
	}

	@Override
	public List<BO> getBos() {
		// TODO Auto-generated method stub
		return boRepository.findAll();
	}
	
	@Override
	public List<BO> getBosByidAgences(String idAgence)
	{
		return boRepository.findByIdAgence(idAgence);
		
	}
}
