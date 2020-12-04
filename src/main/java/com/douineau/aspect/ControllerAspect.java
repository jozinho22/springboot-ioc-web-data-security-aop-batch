package com.douineau.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.douineau.util.CustomLogger;

@Aspect
@Component
public class ControllerAspect {
	
//	@Pointcut("execution(* com.douineau.controller.api.IGenericApiController.*(..))")
//	public void callingRequest() {
//		System.out.println("Pointcut method done");
//	}
	
	@Pointcut("execution(* com.douineau.controller.api.IGenericApiController.*(..))")
	public void callingRequest() {
	}
	
	@Before("callingRequest()")
	public void beforeAdvice(JoinPoint joinPoint) {
	
		System.out.println("StaticPart : " + joinPoint.getStaticPart());

		CustomLogger.getBasicLogger().info("From BasicLogger");
		CustomLogger.getCustomLogger().info("From customLogger");
	}
	
}
