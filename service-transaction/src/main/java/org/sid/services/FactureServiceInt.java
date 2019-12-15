package org.sid.services;

import java.util.List;

import org.sid.entities.Abonne;
import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;

public interface FactureServiceInt {

	Boolean createFacture(Operation operation, String idCompteSrc, String idAbonne);

	List<Abonne> findEntreprises(String domaine);

	ValidationResponse valider(ValidationRequest vq);

}
