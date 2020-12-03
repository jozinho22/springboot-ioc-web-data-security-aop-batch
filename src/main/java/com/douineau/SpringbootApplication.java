package com.douineau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douineau.aspect.ControllerAspect;

//  Replace this 3 annotations :
//  @Configuration
//  @EnableAutoConfiguration
//  @ComponentScan
@SpringBootApplication
public class SpringbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		ControllerAspect.testAop();
	}

}
