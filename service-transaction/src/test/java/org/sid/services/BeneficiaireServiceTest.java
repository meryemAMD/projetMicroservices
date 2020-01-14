package org.sid.services;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.entities.Beneficiaire;
import org.sid.entities.Compte;
import org.sid.proxies.FeignContratServiceClient;


public class BeneficiaireServiceTest {
	@Mock
	BeneficiaireRepository beneficiaireRepository;
	
	@Mock
	FeignContratServiceClient contratService; // proxy vers le service contrat par feign
	
	@InjectMocks
	BeneficiaireService beneficiaireService;

	@Before
    public void init() { MockitoAnnotations.initMocks(this); }

	@Test
	public void createTest(){
		Beneficiaire beneOne = new Beneficiaire();
		beneficiaireService.create(beneOne, "AA");
        verify(beneficiaireRepository, times(1)).save(beneOne);
	}

	@Test
	public void findByIdTest(){
		Beneficiaire bene = new Beneficiaire();
        when(beneficiaireRepository.findByIdBeneficiaire("idBene")).thenReturn(bene);
        Beneficiaire beneResult = beneficiaireService.findById("idBene");
        assertNotNull(beneResult);
	}

	@Test
	public void updateTest(){
		Beneficiaire beneOne = new Beneficiaire();
		beneficiaireService.update(beneOne);
        verify(beneficiaireRepository, times(1)).save(beneOne);    
	}

	@Test
	public void deleteBeneficiaireTest(){
         Beneficiaire b = new Beneficiaire();b.setIdBeneficiaire("AA");
         beneficiaireService.deleteBeneficiaire("AA");
         //verify(beneficiaireRepository, times(1)).delete(b);
	}

	@Test
	public void findAllTest(){
		List<Beneficiaire> list = new ArrayList<Beneficiaire>();
		Beneficiaire beneOne = new Beneficiaire();list.add(beneOne);
		Beneficiaire beneTwo = new Beneficiaire();list.add(beneTwo);
		Beneficiaire beneThree = new Beneficiaire();list.add(beneThree);
		when(beneficiaireRepository.findAll()).thenReturn(list);
        List<Beneficiaire> beneList = beneficiaireService.findAll();
        assertEquals(3, beneList.size());
	    verify(beneficiaireRepository, times(1)).findAll();
	}

	@Test
	public void findByIdCompteSrcTest(){
		List<Beneficiaire> list = new ArrayList<Beneficiaire>();
		Beneficiaire beneOne = new Beneficiaire();	beneOne.setIdCompteSrc("AA"); list.add(beneOne);
		Beneficiaire beneTwo = new Beneficiaire();  beneTwo.setIdCompteSrc("AA"); list.add(beneTwo);
        when(beneficiaireRepository.findByIdCompteSrc("AA")).thenReturn(list);
        List<Beneficiaire> beneList = beneficiaireService.findByIdCompteSrc("AA");
        assertEquals(2, beneList.size());
        verify(beneficiaireRepository, times(1)).findByIdCompteSrc("AA");
	}
	@Test
	public void findByIdAbonneTest(){
		
			List<Compte> list = new ArrayList<Compte>();
			List<Beneficiaire> listBene = new ArrayList<Beneficiaire>();
			List<Beneficiaire> listBene1 = new ArrayList<Beneficiaire>();
			List<Beneficiaire> listBene2 = new ArrayList<Beneficiaire>();
			
			Compte compteSrc1 = new Compte();compteSrc1.setIdCompte("C1");
			Compte compteSrc2 = new Compte();compteSrc2.setIdCompte("C2");
			list.add(compteSrc1);list.add(compteSrc2);

			Beneficiaire beneTwo = new Beneficiaire(); Beneficiaire beneOne = new Beneficiaire();
	       
	        listBene.add(beneTwo);listBene.add(beneOne);listBene1.add(beneOne);listBene2.add(beneTwo);

	        when(contratService.findByIdAbonne("AA")).thenReturn(list);
	        when(beneficiaireRepository.findByIdCompteSrc("C1")).thenReturn(listBene1);
	        when(beneficiaireRepository.findByIdCompteSrc("C2")).thenReturn(listBene2);
	        
	        //test
	        List<Beneficiaire> beneList = beneficiaireService.findByIdAbonne("AA");
	         
	        assertEquals(2, beneList.size());
	       // verify(beneficiaireRepository, times(2));
	        //verify(contratService, times(1));
	    
	}

	//void create(Beneficiaire beneficiaire, String idCompteSrc);

	
}
