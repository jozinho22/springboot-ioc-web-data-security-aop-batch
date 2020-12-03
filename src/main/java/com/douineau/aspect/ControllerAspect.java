package com.douineau.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@ComponentScan("com.douineau.aspect.*")

public class ControllerAspect {
	
//	@Pointcut("execution(* com.douineau.controller.api.IGenericApiController.*(..))")
//	public void callingRequest() {
//		System.out.println("Pointcut method done");
//	}
	
	@Pointcut("execution(* com.douineau.aspect.ControllerAspect.testAop(..))")
	public void callingRequest() {
		System.out.println("Pointcut method done");
	}
	
	@Before("callingRequest()")
	public void beforeAdvice( ) {
		System.out.println("Before advice");
	}
	
	public static void testAop() {
		
	}

}
