package com.multidata.connect.main.configs;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(
basePackages= {
		"com.multidata.connect.main.db3.repositories"
}

		)
public class MongoConfigs {


	@Bean(name="mongoDataSource")
	@ConfigurationProperties(prefix="spring.data.mongodb")
	public DataSource mongoDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	
	
		
	
	
	
	
	
}
