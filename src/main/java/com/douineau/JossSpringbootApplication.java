package com.douineau;

import com.douineau.util.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douineau.annotation.JozinhoApi;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//  @SpringBootApplication replaces this 3 annotations :
//  - @Configuration
//  - @EnableAutoConfiguration
//  - @ComponentScan
@SpringBootApplication
@EnableConfigurationProperties(CustomProperties.class)
public class JossSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JossSpringbootApplication.class, args);
	}

}
