package com.supply.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@Table(name="Delivery")
@XmlRootElement(name = "delivery")
@XmlAccessorType(XmlAccessType.FIELD)
public class Delivery implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name="deliveryId")
	private long deliveryId;
	
	@Column(name="Quantity")
	private Integer Quantity;// this can be an inverse column from Order
							// to have the orderId as an inverse column from Order
							// to have customer Id of the person placing oder
							
	@Column(name="deliveryDate")
	private Date deliveryDate;
	
	@Column(name="TrackGoods") // to know how long it will take to reach customer
	private String TrackGoods;
	
	@Column(name="Status") // status refers to whether the goods are received or not 
	private String Status;
	@Column(name="destination")
	private String destination; // this should be an inverse column from customers
	
	@ManyToOne() 
	@JoinColumn(name = "CustId")
	private Customer customer;
	
	@ManyToOne()
	@JoinColumn(name="invoiceId")
	private Invoice invoice;
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@OneToMany(targetEntity=PurchaseOrder.class,mappedBy="del",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private  List<PurchaseOrder> orders;

	public List<PurchaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<PurchaseOrder> orders) {
		this.orders = orders;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Delivery( Integer quantity, Date deliveryDate,
			String trackGoods, String status, String destination) {
		super();
	
		Quantity = quantity;
		this.deliveryDate = deliveryDate;
		TrackGoods = trackGoods;
		Status = status;
		this.destination = destination;
	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getTrackGoods() {
		return TrackGoods;
	}

	public void setTrackGoods(String trackGoods) {
		TrackGoods = trackGoods;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
