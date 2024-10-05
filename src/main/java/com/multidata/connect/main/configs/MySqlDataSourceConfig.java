package com.multidata.connect.main.configs;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="mySqlEntityManagerFactory",
transactionManagerRef ="mySqlTransactionManager",
basePackages= {
		"com.multidata.connect.main.db1.repositories"
}

		)

public class MySqlDataSourceConfig {
	
	@Primary
	@Bean(name="mySqlDataSource")
	@ConfigurationProperties(prefix="spring.db1.datasource")
	public DataSource mySqlDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="mySqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean studentEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("mySqlDataSource")DataSource dataSource) {
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto","update");
		
		return builder.dataSource(dataSource)
				.properties(properties)
				.packages("com.multidata.connect.main.db1.entities")
				.persistenceUnit("mySql")
				.build();
		
		
		
	}
	
	
	@Primary
	@Bean(name="mySqlTransactionManager")
	public PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManagerFactory")EntityManagerFactory entityManagerFactory ) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	
	
	
	
	

}
