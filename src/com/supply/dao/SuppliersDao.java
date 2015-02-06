package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.supply.model.Suppliers;
import com.supply.utilities.Utility;


public class SuppliersDao {
	EntityManagerFactory emf=null;
	EntityManager em= null;
	
	
	public void saveSuppliers(Suppliers supplier)
	{
		emf=Utility.provideFactory();
	    em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(supplier);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void updateSuppliers(long suppId)
	{
		
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Suppliers supplier=em.find(Suppliers.class,suppId);
		supplier.setSuppId(suppId);
		em.getTransaction().commit();
		 	
		}
	
	public Suppliers searchSuppliers(long suppId)
	{
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Suppliers supplier=em.find(Suppliers.class,suppId);
		return supplier;
		
		}
	
	public void deleteSuppliers(long suppId,String suppName)
	{
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Suppliers supplier=em.find(Suppliers.class,suppId);
		em.remove(supplier);
		em.getTransaction().commit();
		em.close();
		
		}

	
	public List<Suppliers> listSuppliers(){
	       emf = Utility.provideFactory();
	       em = emf.createEntityManager();
	       TypedQuery<Suppliers> query = em.createQuery("SELECT * FROM supply_db.tbl_suppliers", Suppliers.class);
	    List<Suppliers> results = query.getResultList();
	     return results;  
	 }
}
