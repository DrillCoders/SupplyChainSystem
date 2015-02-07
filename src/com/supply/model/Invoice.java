package com.supply.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="INVOICE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="InvoiceId")
 private long invoiceId;
 
 @Column(name="Product_Description")
 private String prodDesc;
 
 @Column(name="Status")
 private String Status;
 
 @Column(name="OrderDate")
 private Date OrderDate;
 
 @Column(name="InvoiceDate")
 private Date invoiceDate;
 
 @ManyToOne()
 @JoinColumn(name="CustId")
 private Customer customers;
 
 public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

 @OneToMany(targetEntity=Delivery.class,mappedBy="invoice",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 private List<Delivery>delivery;


 @OneToMany(targetEntity=PurchaseOrder.class,mappedBy="invoice",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 private List<PurchaseOrder>orders;
 
public List<PurchaseOrder> getOrders() {
	return orders;
}
public void setOrders(List<PurchaseOrder> orders) {
	this.orders = orders;
}

public List<Delivery> getDelivery() {
	return delivery;
}

public void setDelivery(List<Delivery> delivery) {
	this.delivery = delivery;
}

/*public List<OrderItem> getOrders() {
	return orders;
}

public void setOrders(List<OrderItem> orders) {
	this.orders = orders;
}*/

public Invoice() {
	 super();
 }

 public Invoice( String prodDesc,String Status, Date OrderDate,Date invoiceDate) {
  this.prodDesc = prodDesc;
  this.invoiceDate = invoiceDate;
  this.Status=Status;
  this.OrderDate=OrderDate;
 }

 public Date getOrderDate() {
	return OrderDate;
}

public void setOrderDate(Date orderDate) {
	OrderDate = orderDate;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

public long getInvoiceId() {
  return invoiceId;
 }

 public void setInvoiceId(long invoiceId) {
  this.invoiceId = invoiceId;
 }

 public String getProdDesc() {
  return prodDesc;
 }

 public void setProdDesc(String prodDesc) {
  this.prodDesc = prodDesc;
 }

 public Date getInvoiceDate() {
  return invoiceDate;
 }

 public void setInvoiceDate(Date invoiceDate) {
  this.invoiceDate = invoiceDate;
 }
 
 



 
 
 
 
 


}
