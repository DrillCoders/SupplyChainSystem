package com.supply.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private String status;

	@Column(name = "expected_date")
	private Date expectedDate;

	@ManyToMany(mappedBy = "purchaseOrder")
	private Set<StoreStock> orderstock=new HashSet<StoreStock>();

	public PurchaseOrder() {

	}

	public PurchaseOrder(Date purchaseDate, String status,
			Date expectedDate) {
		super();
	
		this.purchaseDate = purchaseDate;
		this.status = status;
		this.expectedDate = expectedDate;
		
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
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
