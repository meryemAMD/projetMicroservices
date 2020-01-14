package org.sid.services;

import java.util.List;


import org.sid.dao.BORepository;
import org.sid.entities.Abonne;
import org.sid.entities.AbonneCount;
import org.sid.entities.BO;
import org.sid.entities.BOCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;


import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Service
public class Reporting_ServiceImp implements Repoting_Service{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	BORepository boRepository;
	@Override
	public List<BOCount> ReportingByBo() {
		// TODO Auto-generated method stub
		Aggregation agg = newAggregation(
				
				group("idAgence").count().as("total"),
				project("total").and("idAgence").previousOperation(),
				sort(Sort.Direction.DESC, "total")
					
			);
			AggregationResults<BOCount> groupResults = mongoTemplate.aggregate(agg, BO.class, BOCount.class);
			List<BOCount> result = groupResults.getMappedResults();
			//System.out.println("le resultat sot ........................"+result);
			
			return result;
			
	}
	@Override
	public List<AbonneCount> ReportingByAbonne() {
		Aggregation agg = newAggregation(
				
				group("idBo").count().as("total"),
				project("total").and("idBo").previousOperation(),
				sort(Sort.Direction.DESC, "total")
					
			);
			AggregationResults<AbonneCount> groupResults = mongoTemplate.aggregate(agg, Abonne.class, AbonneCount.class);
			List<AbonneCount> result = groupResults.getMappedResults();
			//System.out.println("le resultat sot ........................"+result);
			
			return result;
	}
	
}
