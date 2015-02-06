package com.supply.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

// customers are here
import com.supply.model.Customer;
import com.supply.utilities.Utility;

public class CustomerDao {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	public void addCustomer(Customer cust){
		emf = Utility.provideFactory();
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
		em.close();
	}
	public Customer searchCustomer(long id){
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		Customer cust=em.find(Customer.class, id);
			return cust;	
	}
	public void removeCustomer(long id){
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer cust=em.find(Customer.class,id);
		em.remove(cust);
		em.getTransaction().commit();
		em.close();
		
	}
	public void update(long custId,String compName, String address, String emailAddress,String Password,
			String telNo, String paymentMethod){
		emf=Utility.provideFactory();
		em=emf.createEntityManager();
		em.getTransaction().begin();
		Customer cust=em.find(Customer.class, custId);
		cust.setCompName(compName);
		cust.setAddress(address);
		cust.setEmailAddress(emailAddress);
		cust.setPassword(Password);
		cust.setPaymentMethod(telNo);
		cust.setTelNo(paymentMethod);
		em.getTransaction().commit();
			
		
	}
	public List<Customer> findAll(){
		 emf = Utility.provideFactory();
	     em = emf.createEntityManager();
	     TypedQuery<Customer> query = em.createQuery("SELECT c from Customer c", Customer.class);
		 List<Customer> results = query.getResultList();
	   return results;		
	}
}

















