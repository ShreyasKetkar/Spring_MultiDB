package com.multidata.connect.main.configs;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="postgreSqlEntityManagerFactory",
transactionManagerRef ="postgreSqlTransactionManager",
basePackages= {
		"com.multidata.connect.main.db2.repositories"
}

		)
public class PostgresSqlConfig {


	@Bean(name="postgreSqlDataSource")
	@ConfigurationProperties(prefix="spring.db2.datasource")
	public DataSource postgreSqlDataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	
	@Bean(name="postgreSqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean postgreSqlEntityManagerFactory(
			EntityManagerFactoryBuilder builder, @Qualifier("postgreSqlDataSource")DataSource dataSource) {
		
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto","update");
		
		return builder.dataSource(dataSource)
				.properties(properties)
				.packages("com.multidata.connect.main.db2.entities")
				.persistenceUnit("postgreSql")
				.build();
		
		
		
	}
	
	
	
	@Bean(name="postgreSqlTransactionManager")
	public PlatformTransactionManager postgreSqlTransactionManager(@Qualifier("postgreSqlEntityManagerFactory")EntityManagerFactory entityManagerFactory ) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	
	
		
	
	
	
	
	
}
