package com.douineau.util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "test_sb_pu";
    
	public static EntityManager getEntityManager() {
		
		EntityManagerFactory emf = null;
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, ConfigReader.getProperties("/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
		return emf.createEntityManager();
	}

}
