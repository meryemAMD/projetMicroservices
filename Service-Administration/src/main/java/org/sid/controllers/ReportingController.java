package org.sid.controllers;

import java.util.List;

import org.sid.entities.AbonneCount;
import org.sid.entities.BO;
import org.sid.entities.BOCount;
import org.sid.services.Reporting_ServiceImp;
import org.sid.services.Repoting_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Reportings")
public class ReportingController {
	
	@Autowired
	Repoting_Service reportingService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/ReportingBo")
	public List<BOCount> findAllBosByIdAgence() {
		return reportingService.ReportingByBo();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/ReportingAbonne")
	public List<AbonneCount> findAllAbonnesByIdBo() {
		return reportingService.ReportingByAbonne();
    }
	
	

}
