package com.supply.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "tbl_MasterStock")
@XmlRootElement(name = "Mastertock")
@XmlAccessorType(XmlAccessType.FIELD)
public class MasterStock {
	@Id
	@GeneratedValue
	@Column(name = "masterStockId")
	private long masterStockId;
	@Column(name = "stockCatergory")
	private String stockCatergory;
	@Column(name = "description")
	private String description;
	@Column(name = "itemDescription")
	private String itemDescription;
	
	public MasterStock() {
		
	}
	public MasterStock(String stockCatergory, String description,
			String itemDescription) {
		this.stockCatergory = stockCatergory;
		this.description = description;
		this.itemDescription = itemDescription;
			}
	public long getMasterStockId() {
		return masterStockId;
	}
	public void setMasterStockId(long masterStockId) {
		this.masterStockId = masterStockId;
	}
	public String getStockCatergory() {
		return stockCatergory;
	}
	public void setStockCatergory(String stockCatergory) {
		this.stockCatergory = stockCatergory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	 
}
