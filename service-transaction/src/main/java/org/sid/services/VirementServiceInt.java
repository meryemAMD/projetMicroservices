package org.sid.services;

import java.util.List;

import org.sid.entities.Operation;
import org.sid.entities.ValidationRequest;
import org.sid.entities.ValidationResponse;

public interface VirementServiceInt {

	ValidationResponse valider(ValidationRequest validationRequest);

	Boolean create(Operation operation, String idCompteSrc);

}
