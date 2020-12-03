package com.douineau.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class ApiUtil {
	
	private final static String PREFIX = "/api";
	private final static String SLASH = "/";
	
	public static Class<?> getType(HttpServletRequest request, Map<String, Class<?>> apiMapping) {
		
		String req = request.getRequestURI();
		int thirdSlash = req.indexOf(SLASH, PREFIX.length() + 1);
				
		String key = null;
		if(thirdSlash == -1) {
			key = req;
		} else {
			key = req.substring(0, thirdSlash);
		}
		
		Class<?> clazz = apiMapping.get(key);
		System.out.println("clazz = " + clazz);
		return clazz;
	}

}
