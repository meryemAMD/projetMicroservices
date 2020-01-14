package org.sid.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses(value={
  FactureServiceTest.class,
  BeneficiaireServiceTest.class,
  VirementServiceTest.class
})

public class PaiementFactureSuite {

}
