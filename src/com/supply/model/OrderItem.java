package com.supply.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ORDERITEM")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="ITEM_ID")
	 private long ItermId;
	 
	 @Column(name="ITEMQUANTITY")
	 private long ItemQuantity;
	 
	 @Column(name="ITEMDESCRIPTION")
	 private String Itemdescription;
	 
	 @Column(name="ITEMDATE")
	 private Date Itemdate;
	 
	 @Column(name="Unit_Price")
	 private double unitPrice;
	 
	 @Column(name="Total")
	 private double total;
	 
	 @ManyToMany(mappedBy = "orders") 
	  private Set<Customer>customer = new HashSet<Customer>();
	 @OneToMany(targetEntity=ReturnedGoods.class,mappedBy="orders",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 private ReturnedGoods returnedG;
	 
	 @ManyToOne()
	 @JoinColumn(name="ItermId")
	 private PurchaseOrder purchaseOrder;
	 
	 public ReturnedGoods getReturnedG() {
		return returnedG;
	}

	public void setReturnedG(ReturnedGoods returnedG) {
		this.returnedG = returnedG;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	public OrderItem() {
	  
	 }

	public OrderItem(long itermId, long itemQuantity, String itemdescription,
			Date itemdate, double unitPrice, double total,
			Set<Customer> customer) {
		super();
		ItermId = itermId;
		ItemQuantity = itemQuantity;
		Itemdescription = itemdescription;
		Itemdate = itemdate;
		this.unitPrice = unitPrice;
		this.total = total;
		this.customer = customer;
		
	}

	public OrderItem(long itemQuantity, String itemdescription, Date itemdate,
			double unitPrice, double total) {
		super();
		ItemQuantity = itemQuantity;
		Itemdescription = itemdescription;
		Itemdate = itemdate;
		this.unitPrice = unitPrice;
		this.total = total;
		
	}
	
	 public OrderItem(long itermId, long itemQuantity, String itemdescription,
			Date itemdate, double unitPrice, double total) {
		super();
		ItermId = itermId;
		ItemQuantity = itemQuantity;
		Itemdescription = itemdescription;
		Itemdate = itemdate;
		this.unitPrice = unitPrice;
		this.total = total;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getItermId() {
	  return ItermId;
	 }

	 public void setItermId(long itermId) {
	  ItermId = itermId;
	 }

	 public long getItemQuantity() {
	  return ItemQuantity;
	 }

	 public void setItemQuantity(long itemQuantity) {
	  ItemQuantity = itemQuantity;
	 }

	 public String getItemdescription() {
	  return Itemdescription;
	 }

	 public void setItemdescription(String itemdescription) {
	  Itemdescription = itemdescription;
	 }

	 public Date getItemdate() {
	  return Itemdate;
	 }

	 public void setItemdate(Date itemdate) {
	  Itemdate = itemdate;
	 }

}
