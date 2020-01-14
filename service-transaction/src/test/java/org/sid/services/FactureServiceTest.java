package org.sid.services;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Beneficiaire;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.proxies.FeignContratServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

public class FactureServiceTest {
	@Mock
	OperationRepository operationRepository;
	
	@Mock
	CompteRepository compteRepository;
	
	@Mock
	BeneficiaireRepository beneficiaireRepository;
	
	@Mock
	FeignContratServiceClient contratService;
	
	@InjectMocks
	FactureService factureService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	//Boolean createFacture(Operation operation, String idCompteSrc, String idAbonne);
	@Test
	public void createFactureTest(){
			Operation op = new Operation();
			op.setMontant(200);
			String idCompteSrc = "idcompte";
			String idAbonne = "idAbonne";
			Compte compteSrc = new Compte();
			compteSrc.setSolde(20000);
			Compte compteBene = new Compte();
			List<Compte> comptes = new ArrayList<>();
			comptes.add(compteBene);
			when(compteRepository.findByIdCompte(idCompteSrc)).thenReturn(compteSrc);
			when(compteRepository.findByIdAbonne(idAbonne)).thenReturn(comptes);
			//when(factureService.validateSolde("hh", 200)).thenReturn(true);
			FactureService mocked = mock(FactureService.class);
			doReturn(true).when(mocked).validateSolde(idCompteSrc, op.getMontant());
			//when(factureService.validateSolde("hh", 200)).thenReturn(true);
			Boolean result = factureService.createFacture(op, idCompteSrc, idAbonne);
			assertEquals(true, result);
			List<Compte> arg = new ArrayList<>();
			arg.add(compteSrc);
			arg.add(comptes.get(0));
	        verify(operationRepository, times(1)).save(op);
	        verify(compteRepository, times(1)).saveAll(arg );
	}
	
	@Test
	public void createFactureSoldeInsuffisantTest(){
			Operation op = new Operation();
			op.setMontant(200);
			String idCompteSrc = "idcompte";
			String idAbonne = "idAbonne";
			Compte compteSrc = new Compte();
			compteSrc.setSolde(20000);
			Compte compteBene = new Compte();
			List<Compte> comptes = new ArrayList<>();
			comptes.add(compteBene);
			when(compteRepository.findByIdCompte(idCompteSrc)).thenReturn(compteSrc);
			when(compteRepository.findByIdAbonne(idAbonne)).thenReturn(comptes);
			//when(factureService.validateSolde("hh", 200)).thenReturn(true);
			FactureService mocked = mock(FactureService.class);
			doReturn(false).when(mocked).validateSolde(idCompteSrc, op.getMontant());
			//when(factureService.validateSolde("hh", 200)).thenReturn(true);
			Boolean result = factureService.createFacture(op, idCompteSrc, idAbonne);
			assertEquals(true, result);
			List<Compte> arg = new ArrayList<>();
			arg.add(compteSrc);
			arg.add(comptes.get(0));

	}

	//List<Abonne> findEntreprises(String domaine);
	@Test
	public void findEntreprisesTest(){
		String domaine = "domaine";
		List<Abonne> list = new ArrayList<Abonne>();
		Abonne abonneOne = new Abonne();
		Abonne abonneTwo = new Abonne();
		Abonne abonneThree = new Abonne();
         
        list.add(abonneOne);
        list.add(abonneTwo);
        list.add(abonneThree);
         
        when(contratService.findEntrepriseByDomaine(domaine)).thenReturn(list);
         
        //test
        List<Abonne> beneList = factureService.findEntreprises(domaine);
         
        assertEquals(3, beneList.size());
        verify(contratService, times(1)).findEntrepriseByDomaine(domaine);
	}

	//Boolean validerFacture(Operation operation);
	@Test
	public void validerFactureTest(){
		Operation op = new Operation(); op.setIdCompteSrc("src"); op.setMontant(200);
		Compte compteSrc = new Compte(); compteSrc.setSolde(2000);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		Boolean result = factureService.validerFacture(op); 
        verify(compteRepository, times(1)).findByIdCompte("src");
        assertEquals(true, result);
	}
	
	@Test
	public void validerFactureCase2Test(){
		Operation op = new Operation(); op.setIdCompteSrc("src"); op.setMontant(200);
		Compte compteSrc = new Compte(); compteSrc.setSolde(20);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		Boolean result = factureService.validerFacture(op); 
        verify(compteRepository, times(1)).findByIdCompte("src");
        assertEquals(false, result);
	}

	//Boolean validateSolde(String idCompte , float montant) 
	@Test
	public void validateSoldeTest(){
		String idCompteSrc = "idcomptesrc";
		Compte compteSrc = new Compte();
		float montant = 100;
		compteSrc.setSolde(200);
		when(compteRepository.findByIdCompte(idCompteSrc)).thenReturn(compteSrc);
		Boolean result = factureService.validateSolde(idCompteSrc, montant);
        verify(compteRepository, times(1)).findByIdCompte(idCompteSrc);
        assertEquals(true, result);
	}
	
	@Test
	public void validateSoldeCase2Test(){
		String idCompteSrc = "idcomptesrc";
		Compte compteSrc = new Compte();
		float montant = 1000;
		compteSrc.setSolde(200);
		when(compteRepository.findByIdCompte(idCompteSrc)).thenReturn(compteSrc);
		Boolean result = factureService.validateSolde(idCompteSrc, montant);
        verify(compteRepository, times(1)).findByIdCompte(idCompteSrc);
        assertEquals(false, result);
	}


}
