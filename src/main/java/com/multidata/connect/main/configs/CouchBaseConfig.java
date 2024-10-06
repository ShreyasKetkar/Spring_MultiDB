package com.multidata.connect.main.configs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CustomConversions;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SuppressWarnings("deprecation")
@Configuration
@EnableCouchbaseRepositories(
		basePackages= {
				"com.multidata.connect.main.db4.repositories"
		})
public class CouchBaseConfig extends AbstractCouchbaseConfiguration{

	@Override
	public String getConnectionString() {
		
		return "127.0.0.1";
	}

	@Override
	public String getUserName() {
		
		return "Administrator";
	}

	@Override
	public String getPassword() {
		
		return "Shreyas";
	}

	@Override
	public String getBucketName() {
		
		return "employee-data";
	}
	
	@SuppressWarnings("deprecation")
	@Bean(name = "couchbaseConversions")
    public CustomConversions couchbaseConversions() {
        return new CustomConversions(Collections.emptyList());
    }
	
	
	}

