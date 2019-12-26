package org.sid.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class Config extends AbstractMongoConfiguration  {
	
	@Value("${spring.data.mongodb.uri}")
	private String chaineuri ;
	
	@Value("${spring.data.mongodb.database}")
	private String dbname;
	
	@Bean
	MongoTransactionManager transactionManager(MongoDbFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}

	@Override
	protected String getDatabaseName() {
		return dbname;
	}

	@Override
	public MongoClient mongoClient() {

		MongoClientURI uri = new MongoClientURI(chaineuri);  //  "mongodb://meryem:ahmada@cluster0-shard-00-00-p3pao.mongodb.net:27017,cluster0-shard-00-01-p3pao.mongodb.net:27017,cluster0-shard-00-02-p3pao.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		return mongoClient;
	}
	
	 

}
