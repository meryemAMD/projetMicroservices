package org.sid.services;

import java.util.List;

import org.sid.entities.AbonneCount;
import org.sid.entities.BO;
import org.sid.entities.BOCount;
import org.springframework.stereotype.Service;

@Service
public interface Repoting_Service {
	
	public List<BOCount> ReportingByBo();
	public List<AbonneCount> ReportingByAbonne();
}
