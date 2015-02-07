package com.supply.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@Entity
@Table(name="ReturnedGoods")
@XmlRootElement(name = "returnedGoods")
@XmlAccessorType(XmlAccessType.FIELD)

public class ReturnedGoods implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "returnId")	
	private long returnId;
	@Column(name = "prodDescription")	
	private String prodDescrp;
	@Column(name = "returnId")
	private String reason;
	@Column(name = "returnDate")	
	private Date returnDate;
	
	
	public ReturnedGoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnedGoods(long returnId, String prodDescrp, String reason,
			Date returnDate) {
		super();
		this.returnId = returnId;
		this.prodDescrp = prodDescrp;
		this.reason = reason;
		this.returnDate = returnDate;
	}
	@ManyToOne()
	@JoinColumn(name="ItermId")
	private OrderItem items;
	public OrderItem getItems() {
		return items;
	}
	public void setItems(OrderItem items) {
		this.items = items;
	}
	@ManyToOne()
	@JoinColumn(name="storeStockId")
	private StoreStock stock;
	

	public StoreStock getStock() {
		return stock;
	}
	public void setStock(StoreStock stock) {
		this.stock = stock;
	}
	public long getReturnId() {
		return returnId;
	}
	public void setReturnId(long returnId) {
		this.returnId = returnId;
	}
	public String getProdDescrp() {
		return prodDescrp;
	}
	public void setProdDescrp(String prodDescrp) {
		this.prodDescrp = prodDescrp;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
	
}
