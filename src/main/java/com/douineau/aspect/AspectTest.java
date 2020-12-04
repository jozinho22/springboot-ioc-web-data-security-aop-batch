package com.douineau.aspect;

import org.springframework.stereotype.Component;

@Component
public class AspectTest {
	
	public void testAop() {
		System.out.println(getClass().getName());
	}

}
