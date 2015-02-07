package com.supply.testers;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.supply.model.Customer;
import com.supply.model.Invoice;
import com.supply.model.OrderItem;
import com.supply.model.PurchaseOrder;

public class testPurchases {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("supply");
		EntityManager em = emf.createEntityManager();
		// Customer Object class
		Customer cust=new Customer();
		cust.setCompName("Bb Distributors");
		cust.setEmailAddress("bb@Distri@webmail.co.za");
		cust.setPassword("bbDis1974785");
		cust.setTelNo("0698452137");
		cust.setPaymentMethod("eCheck");
		cust.setAddress("32 Newman Crescent Cambridge ,East London 45001");
		
		OrderItem odItem=new OrderItem();
		Set<OrderItem> items = new HashSet<OrderItem>();
		
		odItem.setItemdescription("Fruit");
		odItem.setItemdate(new Date());
		odItem.setItemQuantity(74);
		odItem.setUnitPrice(8.80);
		odItem.setTotal(8.80*74);
		items.add(odItem);
		
		cust.setOrderline(items);
		
		PurchaseOrder purch=new PurchaseOrder();
		/*purch.setItemDescription("Fruit");
		purch.setStatus("paid");*/
		purch.setUnitPrice(8.80);
		purch.setTotal(8.80*74);
		purch.setPurchaseDate(new Date());
		purch.setExpectedDate(new Date());
		//persist data
		em.getTransaction().begin();
		odItem.setPurchaseOrder(purch);
		
		
		Invoice inv=new Invoice();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
