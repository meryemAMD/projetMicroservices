package org.sid.services;

import java.util.List;

import org.sid.dao.CarteRepository;
import org.sid.entities.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteService implements CarteServiceInt {

	@Autowired
	CarteRepository carteRepository;
	
	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#findAll()
	 */
	@Override
	public List<Carte> findAll() {
		// TODO Auto-generated method stub
		return carteRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#findById(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#findById(java.lang.String)
	 */
	@Override
	public Carte findById(String idCarte) {
		// TODO Auto-generated method stub
		return carteRepository.findByIdCarte(idCarte);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#create(org.sid.entities.Carte, java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#create(org.sid.entities.Carte, java.lang.String)
	 */
	@Override
	public void create(Carte carte , String idCompte) {
		carte.setIdCompte(idCompte);
		carteRepository.save(carte);
	}


	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#deleteCarte(org.sid.entities.Carte)
	 */
	
	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#deleteCarte(org.sid.entities.Carte)
	 */
	@Override
	public void deleteCarte(Carte carte) {
		// TODO Auto-generated method stub
		carteRepository.delete(carte);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#update(org.sid.entities.Carte)
	 */
	
	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#update(org.sid.entities.Carte)
	 */
	@Override
	public void update(Carte carte) throws Exception{
		carteRepository.save(carte);
	}


	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#findIdByAbonne(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see org.sid.services.CarteServiceInt#findIdByCompte(java.lang.String)
	 */
	@Override
	public List<Carte> findIdByCompte(String idCompte) {
		// TODO Auto-generated method stub
		return carteRepository.findByIdCompte(idCompte);
	}


}
