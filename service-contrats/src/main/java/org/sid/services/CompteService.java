package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.dao.AbonneRepository;
import org.sid.dao.CompteRepository;
import org.sid.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService implements CompteServiceInt  {
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private AbonneRepository abonneRepository;

	/* (non-Javadoc)
	 * @see org.sid.services.CompteServiceInt#findAll()
	 */
	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.sid.services.CompteServiceInt#findById(java.lang.String)
	 */
	@Override
	public Compte findById(String idCompte) {
		// TODO Auto-generated method stub
		return compteRepository.findByIdCompte(idCompte);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.CompteServiceInt#create(org.sid.entities.Compte, java.lang.String)
	 */
	@Override
	public void create(Compte compte , String idAbonne) {
		compte.setIdAbonne(idAbonne);
		String idBo = abonneRepository.findByIdAbonne(idAbonne).getIdBo();
		compte.setIdBo(idBo);
		compteRepository.save(compte);
	}


	/* (non-Javadoc)
	 * @see org.sid.services.CompteServiceInt#deleteCompte(org.sid.entities.Compte)
	 */
	@Override
	public void deleteCompte(Compte compte) {
		// TODO Auto-generated method stub
		compteRepository.delete(compte);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.CompteServiceInt#update(org.sid.entities.Compte)
	 */
	@Override
	public void update(Compte compte) throws Exception{
		compteRepository.save(compte);
	}


	/* (non-Javadoc)
	 * @see org.sid.services.CompteServiceInt#findIdByAbonne(java.lang.String)
	 */
	@Override
	public List<Compte> findIdByAbonne(String idAbonne) {
		// TODO Auto-generated method stub
		return compteRepository.findByIdAbonne(idAbonne);
	}


}
