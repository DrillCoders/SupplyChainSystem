package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.supply.model.StoreStock;
import com.supply.utilities.Utility;

public class StoreStockDao {
	EntityManagerFactory emf=null;
	EntityManager em= null;
	
	
	public void saveStoreStock(StoreStock storeStock)
	{
		emf=Utility.provideFactory();
	    em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(storeStock);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void updateStoreStock(long storeStockId)
	{
		
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		StoreStock storeStock=em.find(StoreStock.class,storeStockId);
		storeStock.setStoreStockId(storeStockId);
		em.getTransaction().commit();
		 	
		}
	
	public StoreStock searchStoreStock(long storeStockId)
	{
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		StoreStock storeStock=em.find(StoreStock.class,storeStockId);
		return storeStock;
		
		}
	
	public void deleteStoreStock(long storeStockId)
	{
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		StoreStock storeStock=em.find(StoreStock.class,storeStockId);
		em.remove(storeStock);
		em.getTransaction().commit();
		em.close();
		
		}

	
	public List<StoreStock> listStoreStock(){
	       emf = Utility.provideFactory();
	       em = emf.createEntityManager();
	       TypedQuery<StoreStock> query = em.createQuery("SELECT * FROM supply_db.tbl_storeStock", StoreStock.class);
	    List<StoreStock> results = query.getResultList();
	     return results;  
	 }
}
