package org.sid.services;

import java.util.List;
import java.util.Optional;

import org.sid.dao.AbonneRepository;
import org.sid.entities.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class AbonneService implements AbonneServiceInt {
	@Autowired
	private AbonneRepository abonneRepository;

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
	public void create(Abonne abonne) {
		abonneRepository.save(abonne);
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
	public List<Abonne> findByBo(String idBo) {
		// TODO Auto-generated method stub
		return abonneRepository.findByIdBo(idBo);
	}

	/* (non-Javadoc)
	 * @see org.sid.services.AbonneServiceInt#update(org.sid.entities.Abonne)
	 */
	@Override
	public void update(Abonne abonne) throws Exception{
		Abonne ab = abonneRepository.findByIdAbonne(abonne.getIdAbonne());
		abonne.setContrat(ab.getContrat());
		abonneRepository.save(abonne);
	}



}
