package com.supply.model;

import java.io.Serializable;
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

import org.apache.xpath.operations.String;

@Entity
@Table(name = "tblPurchaseOrder")
@XmlRootElement(name = "tblpurchaseOrder")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchaseid")
	private int purchaseId;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	@Column(name = "status")
	private String purchaseState;
	@Column(name="Quantity")
	private long itemQuantity;
	
	@Column(name="Product_Description")
	private String itemDescription;
	
	@Column(name = "expected_date")
	private Date expectedDate;
	
	@Column(name="Unit_Price")
	private double unitPrice;
	@Column(name="Total")
	private double total;
	@ManyToMany(mappedBy = "purchaseOrder")
	private Set<StoreStock> orderstock=new HashSet<StoreStock>();
	
	@OneToMany(targetEntity=OrderItem.class,mappedBy="purchases",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private OrderItem odItem;
	
	public PurchaseOrder() {

	}
	public PurchaseOrder(int purchaseId, Date purchaseDate, String purchaseState,
			long itemQuantity, String itemDescription, Date expectedDate,
			double unitPrice, double total) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseDate = purchaseDate;
		this.purchaseState = purchaseState;
		this.itemQuantity = itemQuantity;
		this.itemDescription = itemDescription;
		this.expectedDate = expectedDate;
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



	public long getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public OrderItem getOdItem() {
		return odItem;
	}

	public void setOdItem(OrderItem odItem) {
		this.odItem = odItem;
	}

	@ManyToOne()
	@JoinColumn(name="deliveryId")
	private Delivery delivery;
	
	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	@ManyToOne()
	@JoinColumn(name="invoiceId")
	private Invoice invoice;
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	
	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getStatus() {
		return purchaseState;
	}

	public void setPurchaseState(String purchaseState) {
		this.purchaseState = purchaseState;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Set<StoreStock> getOrderstock() {
		return orderstock;
	}

	public void setOrderstock(Set<StoreStock> orderstock) {
		this.orderstock = orderstock;
	}
	

}
