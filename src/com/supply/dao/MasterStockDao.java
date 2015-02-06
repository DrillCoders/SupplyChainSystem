package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.supply.model.MasterStock;
import com.supply.utilities.Utility;

public class MasterStockDao {
	EntityManagerFactory emf=null;
	EntityManager em= null;
	
	
	public void saveMasterStock(MasterStock masterStock)
	{
		emf=Utility.provideFactory();
	    em=emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(masterStock);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void updateMasterStock(long masterStockId)
	{
		
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		MasterStock masterStock=em.find(MasterStock.class,masterStockId);
		masterStock.setMasterStockId(masterStockId);
		em.getTransaction().commit();
		 	
		}
	
	public MasterStock searchMasterStock(long masterStockId)
	{
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		MasterStock masterStock=em.find(MasterStock.class,masterStockId);
		return masterStock;
		
		}
	
	public void deleteMasterStock(long masterStockId,String stockCatergory)
	{
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		MasterStock masterStock=em.find(MasterStock.class,masterStockId);
		em.remove(masterStock);
		em.getTransaction().commit();
		em.close();
		
		}

	
	public List<MasterStock> listMasterStock(){
	       emf = Utility.provideFactory();
	       em = emf.createEntityManager();
	       TypedQuery<MasterStock> query = em.createQuery("SELECT * FROM supply_db.tbl_masterStock", MasterStock.class);
	    List<MasterStock> results = query.getResultList();
	     return results;  
	 }
}
