package com.douineau.testspringboot.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class ApiUtil {
	
	public static Class<?> getType(HttpServletRequest request, Map<String, Class<?>> apiMapping) {
		
		String req = request.getRequestURI();
		String key = null;
		int occurances = StringUtils.countOccurrencesOf(req, "/");
		int lastSlash = req.lastIndexOf("/");
		if(occurances < 3) {
			key = req;
		} else {
			key = req.substring(0, lastSlash);
		}
		
		Class<?> clazz = apiMapping.get(key);
		System.out.println("clazz = " + clazz);
		return clazz;
	}

}
