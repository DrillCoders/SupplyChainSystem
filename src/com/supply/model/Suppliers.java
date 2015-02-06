package com.supply.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_Suppliers")
@XmlRootElement(name = "Suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Suppliers {
	@Id
	@GeneratedValue
	@Column(name = "suppId")
	private long suppId;
	@Column(name = "suppName")
	private String supplyName;
	@Column(name = "productDescription")
    private String productDescription;
	@Column(name = "supQuantity")
    private int supQuantity;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
    private String city;
	@Column(name = "phone")
    private String phone;
	@Column(name = "fax")
    private String fax;
	@Column(name = "email")
	private String email;
	
	public Suppliers() {
			}

	public Suppliers(String supplyName, String productDescription,
			int supQuantity, String address, String city, String phone,
			String fax, String email) {
		super();
		this.supplyName = supplyName;
		this.productDescription = productDescription;
		this.supQuantity = supQuantity;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
	}
	
	
		
	public Suppliers(long suppId, String supplyName, String productDescription,
			int supQuantity, String address, String city, String phone,
			String fax, String email, Set<StoreStock> storeStock) {
		this.suppId = suppId;
		this.supplyName = supplyName;
		this.productDescription = productDescription;
		this.supQuantity = supQuantity;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
		this.storeStock = storeStock;
	}


	public Suppliers(long suppId, String supplyName, String productDescription,
			int supQuantity, String address, String city, String phone,
			String fax, String email) {
		super();
		this.suppId = suppId;
		this.supplyName = supplyName;
		this.productDescription = productDescription;
		this.supQuantity = supQuantity;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.fax = fax;
		this.email = email;
	}



	@ManyToMany (cascade = {CascadeType.ALL})
	@JoinTable(name="Supply_Stock",
	    joinColumns={@JoinColumn(name="suppId")},inverseJoinColumns={@JoinColumn(name="storeStockId")})
	
	
	private Set<StoreStock> storeStock =new HashSet<StoreStock>();

	public long getSuppId() {
		return suppId;
	}

	public void setSuppId(long suppId) {
		this.suppId = suppId;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getSupQuantity() {
		return supQuantity;
	}

	public void setSupQuantity(int supQuantity) {
		this.supQuantity = supQuantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<StoreStock> getStoreStock() {
		return storeStock;
	}

	public void setStoreStock(Set<StoreStock> storeStock) {
		this.storeStock = storeStock;
	}
}
	
	/*
	
	public Set<StoreStock> getStoreStock() {
		return storeStock;
	}

	public void setStoreStock(Set<StoreStock> storeStock) {
		this.storeStock = storeStock;
	}

	public Suppliers() {
		
	}

	public Suppliers(String supplyName, String address, String email,
			String productDescription) {
		
		this.supplyName = supplyName;
		this.address = address;
		this.email = email;
		this.productDescription = productDescription;
	}

	public Suppliers(long suppId, String supplyName, String address,
			String email, String productDescription, Set<StoreStock> storeStock) {
		super();
		this.suppId = suppId;
		this.supplyName = supplyName;
		this.address = address;
		this.email = email;
		this.productDescription = productDescription;
		this.storeStock = storeStock;
	}

	public Suppliers(long suppId,String supplyName, String address, String email,
			String productDescription) {
		super();
		this.suppId = suppId;
		this.supplyName = supplyName;
		this.address = address;
		this.email = email;
		this.productDescription = productDescription;
	}

	public long getSuppId() {
		return suppId;
	}

	public void setSuppId(long suppId) {
		this.suppId = suppId;
	}

	public String getSupplyName() {
		return supplyName;
	}

	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	}
*/