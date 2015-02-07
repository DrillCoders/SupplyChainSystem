package com.supply.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_StoreStock")
@XmlRootElement(name = "StoreStockDao")
@XmlAccessorType(XmlAccessType.FIELD)
public class StoreStock {
	@Id
/*	@GeneratedValue*/
	@Column(name = "storeStockId")
	private long storeStockId;
	@Column(name = "description")
	private String description;
	@Column(name = "unitPrice")
	private Double unitPrice;
	@Column(name = "totalPrice")
	private Double totalPrice;
	@Column(name = "quantity")
	private Integer quantity;
	
	
	//private Suppliers supp;
	
	@ManyToMany(mappedBy="storeStock")
	private Set<Suppliers>supplier = new HashSet<Suppliers>();
	@OneToMany(targetEntity=ReturnedGoods.class,mappedBy="storeStock",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private ReturnedGoods returnedG;

	public ReturnedGoods getReturnedG() {
		return returnedG;
	}
	public void setReturnedG(ReturnedGoods returnedG) {
		this.returnedG = returnedG;
	}


	public Set<Suppliers> getSupplier() {
		return supplier;
	}


	public void setSupplier(Set<Suppliers> supplier) {
		this.supplier = supplier;
	}


	public StoreStock(long storeStockId, String description, Double unitPrice,
			Double totalPrice, Integer quantity, Set<Suppliers> supplier,Suppliers supp) {
		super();
		this.storeStockId = storeStockId;
		this.description = description;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.supplier = supplier;
		//this.supp=supp;
	}

	
	public StoreStock(long storeStockId, String description, Double unitPrice,
			Double totalPrice, Integer quantity) {
		super();
		this.storeStockId = storeStockId;
		this.description = description;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}


	public StoreStock() {
	
	}

	public StoreStock(String description, Double unitPrice, Double totalPrice,
			Integer quantity) {
		super();
		this.description = description;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	

/*	public Suppliers getSupp() {
		return supp;
	}


	public void setSupp(Suppliers supp) {
		this.supp = supp;
	}*/


	public long getStoreStockId() {
		return storeStockId;
	}

	public void setStoreStockId(long storeStockId) {
		this.storeStockId = storeStockId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
