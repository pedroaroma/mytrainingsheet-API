package com.br.home.mytrainingsheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"com.br.home.mytrainingsheet.entity"})
@ComponentScan(basePackages = {"com.br.home.mytrainingsheet.*"})
@EnableJpaRepositories(basePackages = {"com.br.home.mytrainingsheet.repository"})
@EnableTransactionManagement
//@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class MytrainingsheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytrainingsheetApplication.class, args);
	}

}
