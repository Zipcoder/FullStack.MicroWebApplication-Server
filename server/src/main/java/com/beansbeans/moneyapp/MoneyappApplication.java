package com.beansbeans.moneyapp;

import com.beansbeans.moneyapp.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories
public class MoneyappApplication {
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(MoneyappApplication.class, args);
	}


}
