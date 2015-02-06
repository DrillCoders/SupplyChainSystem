package com.supply.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {
	private static final EntityManagerFactory entityManagerFactory = produceObj();
	private static EntityManagerFactory produceObj() {	
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supply");	
		return entityManagerFactory;
	}
	public static EntityManagerFactory provideFactory(){	
		return entityManagerFactory;	
	}

}
