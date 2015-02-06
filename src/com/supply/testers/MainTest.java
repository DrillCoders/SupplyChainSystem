package com.supply.testers;

/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

*/

import com.supply.dao.SuppliersDao;
//import com.supply.model.StoreStock;
import com.supply.model.Suppliers;

public class MainTest {

	public static void main(String[] args) {
		
		Suppliers supplier = new Suppliers();
		SuppliersDao sdao = new SuppliersDao();
		supplier.setSupplyName("VV");
		supplier.setProductDescription("toiletries");
		supplier.setEmail("lafage");
		supplier.setAddress("Capetown");
		/*Suppliers supplier4 = new Suppliers("meat market", "JHB", "vors",
				"butchery");
		Suppliers supplier1 = new Suppliers("FMD", "Capetown", "lafage",
				"toiletries");
		Suppliers supplier2 = new Suppliers("GB Farming", "LouisTrichardt",
				"fruits & Veg", "Cabbages");
		Suppliers supplier3 = new Suppliers("nkhensani G.Delear", "malamulele",
				"groceries", "lucky star");
		sdao.saveSuppliers(supplier);
		sdao.saveSuppliers(supplier1);
		sdao.saveSuppliers(supplier2);
		sdao.saveSuppliers(supplier3);
		sdao.saveSuppliers(supplier4);
		sdao.deleteSuppliers((long) 5, "VV");
		sdao.saveSuppliers(supplier);*/
		// sdao.deleteSuppliers(supplier);
		/*
		 * Suppliers supplier2=new
		 * Suppliers("GB Farming","fruits & Veg","Cabbages","LouisTrichardt");
		 * Suppliers supplier3=new
		 * Suppliers("nkhensani","groceries","lucky star","malamulele");
		 */
		   

	}

}





























/*
*/
