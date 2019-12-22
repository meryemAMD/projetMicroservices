package org.sid.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.sid.dao.AbonneRepository;
import org.sid.dao.ContratRepository;
import org.sid.dao.OffreRepository;
import org.sid.entities.Contrat;
import org.sid.entities.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffreService implements OffreServiceInt {
	
	@Autowired
	OffreRepository offreRepository;
	
	
	@Autowired
	private AbonneRepository abonneRepository;
	
	@Autowired 
	ContratRepository contratRepository;

	/* (non-Javadoc)
	 * @see org.sid.services.OffreServiceInt#findAll()
	 */
	@Override
	public List<Offre> findAll() {
		// TODO Auto-generated method stub
		return offreRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see org.sid.services.OffreServiceInt#findById(java.lang.String)
	 */
	@Override
	public Offre findById(String idOffre) {
		// TODO Auto-generated method stub
		return offreRepository.findByIdOffre(idOffre);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.OffreServiceInt#saveOrUpdateOffre(org.sid.entities.Offre)
	 */
	@Override
	public void saveOrUpdateOffre(Offre offre) {
		// TODO Auto-generated method stub
		offreRepository.save(offre);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.OffreServiceInt#deleteOffre(org.sid.entities.Offre, java.lang.String)
	 */
	@Override
	public void deleteOffre(String idOffre, String idContrat) {
		Offre offre = new Offre();
		offre.setIdOffre(idOffre);
		offreRepository.delete(offre);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.OffreServiceInt#updateOffre(org.sid.entities.Offre)
	 */
	@Override
	public void updateOffre(Offre offre) {
		// TODO Auto-generated method stub
		offreRepository.save(offre);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.OffreServiceInt#saveOffre(org.sid.entities.Offre, java.lang.String)
	 */
	@Override
	public void saveOffre(Offre offre, String idContrat) {
		// TODO Auto-generated method stub
		offre.setIdContrat(idContrat);
		offreRepository.save(offre);
	}

	@Override
	public List<Offre> findByAbonne(String idAbonne) {
		Contrat contrat = contratRepository.findByIdAbonne(idAbonne);
		return offreRepository.findByIdContrat(contrat.getIdContrat());
		
	}

	@Override
	public void saveOffreByIdAbonne(Offre offre, String idAbonne) {
		Contrat contrat = contratRepository.findByIdAbonne(idAbonne);
		offre.setIdContrat(contrat.getIdContrat());
		offreRepository.save(offre);
	}


}
