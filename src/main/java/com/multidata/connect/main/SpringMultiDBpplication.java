package com.multidata.connect.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

public class SpringMultiDBpplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMultiDBpplication.class, args);
	}

}
