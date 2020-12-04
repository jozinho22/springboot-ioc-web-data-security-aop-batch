package com.douineau;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.douineau.aspect.AspectTest;

//  @SpringBootApplication replaces this 3 annotations :
//  - @Configuration
//  - @EnableAutoConfiguration
//  - @ComponentScan
@SpringBootApplication
public class JossSpringbootApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(JossSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AspectTest myBean = applicationContext.getBean(AspectTest.class);
		myBean.testAop();
	}
}
