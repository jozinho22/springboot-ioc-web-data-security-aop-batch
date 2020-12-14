package com.douineau;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douineau.annotation.JozinhoApi;

//  @SpringBootApplication replaces this 3 annotations :
//  - @Configuration
//  - @EnableAutoConfiguration
//  - @ComponentScan
@SpringBootApplication
public class JossSpringbootApplication {

//	@Autowired
//	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(JossSpringbootApplication.class, args);
	}

}
