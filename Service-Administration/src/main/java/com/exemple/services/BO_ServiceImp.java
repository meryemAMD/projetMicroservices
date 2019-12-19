package com.exemple.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.AbonneRepository;
import com.example.repositories.BORepository;
import com.exemple.entities.Abonne;
import com.exemple.entities.Agence;
import com.exemple.entities.BO;

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
	public void deleteBo(int id) {
		boRepository.deleteById(id);
		
	}

	@Override
	public BO FindByIdBo(int id) {
		Optional<BO> bo = this.boRepository.findById(id);
		if (bo.isPresent()) {
		    return bo.get();
		} else {
		    return null;
		}
	
	}

	@Override
	public List<BO> FindAllBo() {
		// TODO Auto-generated method stub
		return boRepository.findAll();
	}
	
	//find BO by id Agence
	public List<BO> findByAgence(int idAgence) {
		// TODO Auto-generated method stub
		return boRepository.findByIdAgence(idAgence);
	}
	//find set of abonees by id Bo
	public List<Abonne> findByBo(int idBo) {
			// TODO Auto-generated method stub
			return aboneeRepository.findByIdBo(idBo);
		}

}
