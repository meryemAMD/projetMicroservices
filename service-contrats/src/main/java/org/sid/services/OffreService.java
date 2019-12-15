package org.sid.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	public void deleteOffre(Offre offre, String idContrat) {
		System.out.println(idContrat);
		//ContratService contratService = new ContratService();
		Contrat contrat =  contratRepository.findByIdContrat(idContrat);
		Collection<Offre> offres = contrat.getOffres();
		offres.removeIf((Offre offre1) -> offre1.getIdOffre() == offre1.getIdOffre());
		contrat.setOffres(offres);
		offreRepository.delete(offre);
		//contratService.createContrat(contrat);
		contratRepository.save(contrat);
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
		ContratServiceInt contratService = new ContratService();
		Contrat contrat =  contratService.findById(idContrat);
		contrat.getOffres().add(offre);
		offreRepository.save(offre);
		contratService.createContrat(contrat);
	}


}
