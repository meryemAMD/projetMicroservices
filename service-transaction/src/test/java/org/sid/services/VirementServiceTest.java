package org.sid.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.sid.dao.AbonneRepository;
import org.sid.dao.BeneficiaireRepository;
import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.Abonne;
import org.sid.entities.Beneficiaire;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;
import org.sid.proxies.FeignContratServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class VirementServiceTest {

	@Mock
	OperationRepository operationRepository;
	
	@Mock
	CompteRepository compteRepository;
	
	@Mock
	BeneficiaireRepository beneficiaireRepository;
	
	@Mock
	AbonneRepository abonneRepository;
	
	@Mock
	FeignContratServiceClient contratService;
	
	@InjectMocks
	VirementService virementService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	//ValidationResponse valider(ValidationRequest validationRequest);
	@Test
	public void validerTest(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(20000);compteSrc.setIdAbonne("ab");
		Compte compteBene = new Compte();compteBene.setIdAbonne("ab2");
		Beneficiaire bene = new Beneficiaire();bene.setIdCompteBeneficiaire("bene");
		ValidationRequest vq = new ValidationRequest();vq.setIdBeneficiaire("bene");vq.setIdCompteSrc("src");vq.setMontant(200);
		
		ValidationResponse expected = new ValidationResponse();
		expected.setBeneficiaire(bene);expected.setType("Virement externe");expected.setEtat(true);
		expected.setIdCompteSrc(vq.getIdCompteSrc());expected.setMontant(vq.getMontant());

		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(beneficiaireRepository.findByIdBeneficiaire("bene")).thenReturn(bene);
		when(compteRepository.findByIdCompte("bene")).thenReturn(compteBene);
		when(contratService.validatePlafond(compteSrc.getIdAbonne(), vq.getMontant(), "Virement externe")).thenReturn(true);
		VirementService mocked = mock(VirementService.class);

		doReturn("Virement externe").when(mocked).getTypeOperation(compteSrc  , compteBene);
		doReturn(true).when(mocked).validatePlafond(compteSrc.getIdAbonne(), vq.getMontant() ,"Virement externe");
		doReturn(true).when(mocked).validateSolde("src", 200);

		ValidationResponse result = virementService.valider(vq);
		
		assertEquals(true, result.getEtat());
        verify(beneficiaireRepository, times(1)).findByIdBeneficiaire("bene");
        verify(compteRepository, times(2)).findByIdCompte("src");
	}
	
	@Test
	public void validerTestPlafondDepasse(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(20000);compteSrc.setIdAbonne("ab");
		Compte compteBene = new Compte();compteBene.setIdAbonne("ab2");
		Beneficiaire bene = new Beneficiaire();bene.setIdCompteBeneficiaire("bene");
		ValidationRequest vq = new ValidationRequest();vq.setIdBeneficiaire("bene");vq.setIdCompteSrc("src");vq.setMontant(200);
		
		ValidationResponse expected = new ValidationResponse();
		expected.setBeneficiaire(bene);expected.setType("Virement externe");expected.setEtat(true);
		expected.setIdCompteSrc(vq.getIdCompteSrc());expected.setMontant(vq.getMontant());

		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(beneficiaireRepository.findByIdBeneficiaire("bene")).thenReturn(bene);
		when(compteRepository.findByIdCompte("bene")).thenReturn(compteBene);
		when(contratService.validatePlafond(compteSrc.getIdAbonne(), vq.getMontant(), "Virement externe")).thenReturn(false);
		VirementService mocked = mock(VirementService.class);

		doReturn("Virement externe").when(mocked).getTypeOperation(compteSrc  , compteBene);
		doReturn(false).when(mocked).validatePlafond(compteSrc.getIdAbonne(), vq.getMontant() ,"Virement externe");
		doReturn(true).when(mocked).validateSolde("src", 200);

		ValidationResponse result = virementService.valider(vq);
		
		assertEquals(false, result.getEtat());
		assertEquals("Vous avez dépassé les plafonds!!", result.getMessage());

	}
	
	@Test
	public void validerTestSoldeInsuffisent(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(20);compteSrc.setIdAbonne("ab");
		Compte compteBene = new Compte();compteBene.setIdAbonne("ab2");
		Beneficiaire bene = new Beneficiaire();bene.setIdCompteBeneficiaire("bene");
		ValidationRequest vq = new ValidationRequest();vq.setIdBeneficiaire("bene");vq.setIdCompteSrc("src");vq.setMontant(200);
		
		ValidationResponse expected = new ValidationResponse();
		expected.setBeneficiaire(bene);expected.setType("Virement externe");expected.setEtat(true);
		expected.setIdCompteSrc(vq.getIdCompteSrc());expected.setMontant(vq.getMontant());

		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(beneficiaireRepository.findByIdBeneficiaire("bene")).thenReturn(bene);
		when(compteRepository.findByIdCompte("bene")).thenReturn(compteBene);
		when(contratService.validatePlafond(compteSrc.getIdAbonne(), vq.getMontant(), "Virement externe")).thenReturn(true);
		VirementService mocked = mock(VirementService.class);

		doReturn("Virement externe").when(mocked).getTypeOperation(compteSrc  , compteBene);
		doReturn(true).when(mocked).validatePlafond(compteSrc.getIdAbonne(), vq.getMontant() ,"Virement externe");
		doReturn(false).when(mocked).validateSolde("src", 200);

		ValidationResponse result = virementService.valider(vq);
		
		assertEquals(false, result.getEtat());
		assertEquals("Votre solde est insuffisent!!", result.getMessage());
	}

	//Boolean create(Operation operation, String idCompteSrc);
	@Test
	public void createTest(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(20000);compteSrc.setIdAbonne("ab");
		Compte compteBene = new Compte();compteBene.setIdAbonne("ab2");
		Beneficiaire bene = new Beneficiaire();bene.setIdCompteBeneficiaire("bene");
		
		Operation op = new Operation();op.setIdCompteSrc("src");op.setMontant(200);op.setIdCompteBeneficiaire("bene");

		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("bene")).thenReturn(compteBene);
		when(contratService.validatePlafond(compteSrc.getIdAbonne(), op.getMontant(), "Virement externe")).thenReturn(true);
		VirementService mocked = mock(VirementService.class);

		doReturn("Virement externe").when(mocked).getTypeOperation(compteSrc  , compteBene);
		doReturn(true).when(mocked).validatePlafond(compteSrc.getIdAbonne(), op.getMontant() ,"Virement externe");
		doReturn(true).when(mocked).validateSolde("src", 200);

		Boolean result = virementService.create(op,"src");
		
		assertEquals(true, result);
        verify(compteRepository, times(2)).findByIdCompte("src");
        List arg = new ArrayList<>(); arg.add(compteSrc); arg.add(compteBene);
        verify(compteRepository, times(1)).saveAll(arg);
        verify(operationRepository, times(1)).save(op);
        
	}
	
	@Test
	public void createCase2Test(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(20000);compteSrc.setIdAbonne("ab");
		Compte compteBene = new Compte();compteBene.setIdAbonne("ab2");
		Beneficiaire bene = new Beneficiaire();bene.setIdCompteBeneficiaire("bene");
		
		Operation op = new Operation();op.setIdCompteSrc("src");op.setMontant(200);op.setIdCompteBeneficiaire("bene");

		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		when(compteRepository.findByIdCompte("bene")).thenReturn(compteBene);
		when(contratService.validatePlafond(compteSrc.getIdAbonne(), op.getMontant(), "Virement externe")).thenReturn(false);
		VirementService mocked = mock(VirementService.class);

		doReturn("Virement externe").when(mocked).getTypeOperation(compteSrc  , compteBene);
		doReturn(true).when(mocked).validatePlafond(compteSrc.getIdAbonne(), op.getMontant() ,"Virement externe");
		doReturn(false).when(mocked).validateSolde("src", 200);

		Boolean result = virementService.create(op,"src");
		
		assertEquals(false, result);
        verify(compteRepository, times(2)).findByIdCompte("src");
        List arg = new ArrayList<>(); arg.add(compteSrc); arg.add(compteBene);
        
	}
	
	//String getTypeOperation(Compte compteSrc, Compte compteBene) {
	@Test
	public void getTypeOperationTest(){
		
		Compte compteSrc = new Compte();compteSrc.setIdAbonne("ab2");
		Compte compteBene = new Compte();compteBene.setIdAbonne("ab2");

		String type = virementService.getTypeOperation(compteSrc, compteBene);
		
		assertEquals("Virement interne", type);

	}

	@Test
	public void validateSoldeTest(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(200);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		Boolean res = virementService.validateSolde("src", 100);
		assertEquals(true, res);

	}
	
	@Test
	public void validateSoldeInsuffisentTest(){
		
		Compte compteSrc = new Compte();compteSrc.setSolde(200);
		when(compteRepository.findByIdCompte("src")).thenReturn(compteSrc);
		Boolean res = virementService.validateSolde("src", 500);
		assertEquals(false, res);

	}
	
}
