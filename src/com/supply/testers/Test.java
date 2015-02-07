package com.supply.testers;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.supply.model.MasterStock;
import com.supply.model.StoreStock;
import com.supply.model.Suppliers;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("supply");
		EntityManager em = emf.createEntityManager();
		MasterStock ms= new MasterStock();
		StoreStock ss = new StoreStock();
		Suppliers supplier4 = new Suppliers("meat market", "JHB",89,"pretoria","0123431290","0787899445", "vors","butchery");	
		Suppliers supplier1 = new Suppliers("FMD", "Capetown", 987,"lafage","0123378654","0843683986","Msoindzu","toiletries");
		//Suppliers supplier2 = new Suppliers("GB Farming", "LouisTrichardt","fruits & Veg", "Cabbages");
		//Suppliers supplier3 = new Suppliers("nkhensani G.Delear", "malamulele","groceries", "lucky star");
		
		Set<Suppliers> sup =new HashSet<Suppliers>();
		//Set<StoreStock> storest= new HashSet<StoreStock>();
		
		
		sup.add(supplier4);
		sup.add(supplier1);
		/*sup.add(supplier2);
		sup.add(supplier3);*/
		
		
		ss.setQuantity(10);
		ss.setStoreStockId((long) 78);
		ss.setTotalPrice(75.00);
		ss.setUnitPrice(7.50);
		ss.setDescription("colgate");		
		ss.getSupplier().add(supplier4);
		supplier1.getStoreStock().add(ss);
		
		ms.setDescription("beverages");
		//ms.setExpiryDate(new Date());
		ms.setStockCatergory("drinks");
		ms.setItemDescription("washingPwder");
		/*supplier4.setMasterStock(ms);
		supplier1.setMasterStock(ms);
		supplier2.setMasterStock(ms);
		supplier3.setMasterStock(ms);
		supplier4.setStoreStock(ss);
		ss.setMasterStock(ms);*/
		
		
		em.getTransaction().begin();
		em.persist(ms);
		em.persist(ss);
		
		em.persist(supplier1);
		/*em.persist(supplier3);
		em.persist(supplier2);*/
		em.persist(supplier4);
		em.getTransaction().commit();
				 
	}

}
