package org.sid.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sid.dao.AbonneRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.ContratRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.sid.entities.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class AbonneService implements AbonneServiceInt {
	@Autowired
	private AbonneRepository abonneRepository;
	
	@Autowired
	private ContratRepository contratRepository;
	
	@Autowired
	private CompteRepository compteRepository;

	/* (non-Javadoc)
	 * @see org.sid.services.AbonneServiceInt#findAll()
	 */
	@Override
	public List<Abonne> findAll() {
		// TODO Auto-generated method stub
		return abonneRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.sid.services.AbonneServiceInt#findById(java.lang.String)
	 */
	@Override
	public Abonne findById(String id) {
		// TODO Auto-generated method stub
		return abonneRepository.findByIdAbonne(id);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.AbonneServiceInt#create(org.sid.entities.Abonne)
	 */
	@Override
	public void createIndividu(Abonne abonne) {
		abonne.setIdAbonne(abonne.getCin());
		abonneRepository.save(abonne);
		
		Date now = new Date();
		Date exp = new Date();
		Contrat contrat = new Contrat();
		contrat.setDateDebut(new Date());
		exp.setYear(now.getYear()+1);
		contrat.setDateExpiration(exp);
		contrat.setIdAbonne(abonne.getIdAbonne());
		contratRepository.save(contrat);
		
		Compte compteParDefaut = new Compte();
		compteParDefaut.setIdAbonne(abonne.getCin());
		compteParDefaut.setIdBo(abonne.getIdBo());
		compteParDefaut.setSolde(0);

		compteRepository.save(compteParDefaut);
	}
	
	@Override
	public void createEntreprise(Abonne abonne) {
		abonne.setIdAbonne(abonne.getSIRET());
		abonneRepository.save(abonne);
		
		Date now = new Date();
		Date exp = new Date();
		Contrat contrat = new Contrat();
		contrat.setDateDebut(new Date());
		exp.setYear(now.getYear()+1);
		contrat.setDateExpiration(exp);
		contrat.setIdAbonne(abonne.getIdAbonne());
		contratRepository.save(contrat);
		
		Compte compteParDefaut = new Compte();
		compteParDefaut.setIdAbonne(abonne.getCin());
		compteParDefaut.setIdBo(abonne.getIdBo());
		compteParDefaut.setSolde(0);

		compteRepository.save(compteParDefaut);
	}


	/* (non-Javadoc)
	 * @see org.sid.services.AbonneServiceInt#deleteAbonne(org.sid.entities.Abonne)
	 */
	@Override
	public void deleteAbonne(Abonne abonne) {
		// TODO Auto-generated method stub
		abonneRepository.delete(abonne);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.AbonneServiceInt#findByBo(java.lang.String)
	 */
	@Override
	public List<Abonne> findByBo(String idBo , String type , int pageSize , int pageNum ) {
		// TODO Auto-generated method stub
		int limInf = pageSize*(pageNum-1);
		int limSup = pageSize*(pageNum-1)+pageSize;
		List<Abonne> abonnes = abonneRepository.findByIdBoAndType(idBo, type);
		if(abonnes.size()<pageSize*(pageNum-1)+pageSize) {
			if(abonnes.size() >= pageSize*(pageNum-1)) limSup = abonnes.size();
			else return null;
		}
		return abonnes.subList(limInf,limSup);
	}


	@Override
	public void update(Abonne abonne) throws Exception{
		abonneRepository.save(abonne);
	}

	@Override
	public void changeState(String idAbonne, boolean b) {
		Abonne abonne = abonneRepository.findByIdAbonne(idAbonne);
		abonne.setActif(b);
		abonneRepository.save(abonne);
	}

	@Override
	public List<Abonne> findEntreprises(String domaine) {
		List<Abonne> abonnes = abonneRepository.findByDomaine(domaine);
		
		return abonnes;
	}

	@Override
	public Abonne findByIdUser(String idUser) {
		return abonneRepository.findByIdUser(idUser);
	}

}
