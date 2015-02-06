package com.supply.model;

import java.io.Serializable;
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
@Table(name="Customer")
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable{
	
@Id
@GeneratedValue
@Column(name="CustId")
/*@XmlAttribute*/
private long CustId;
//comment
@Column(name="CompName")
private String compName;

@Column(name="Address")
private String Address;

@Column(name="emailAddress")
private String emailAddress;
@Column(name="Password")
private String Password;

@Column(name="telNo")
private String telNo;

@Column(name="paymentMethod")
private String paymentMethod;



@ManyToMany( cascade ={ CascadeType.ALL})
@JoinTable(
		name="Customer_Order",
		joinColumns={@JoinColumn(name="CustId")},inverseJoinColumns={@JoinColumn(name="orderId")})
		private Set<OrderItem> orderline = new HashSet<OrderItem>();
		
public Set<OrderItem> getOrderline() {
	return orderline;
}

public void setOrderline(Set<OrderItem> orderline) {
	this.orderline = orderline;
}

/*@OneToMany(targetEntity=OrderItem.class,mappedBy="cust",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<OrderItem>orders;

public List<OrderItem> getOrders() {
	return orders;
}

public void setOrders(List<OrderItem> orders) {
	this.orders = orders;
}*/

@OneToMany(targetEntity=Delivery.class,mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Delivery>delivery;


@OneToMany(targetEntity=Invoice.class,mappedBy="customers",cascade=CascadeType.ALL,fetch=FetchType.LAZY)

private List<Invoice> invoice;


public List<Invoice> getInvoice() {
	return invoice;
}

public void setInvoice(List<Invoice> invoice) {
	this.invoice = invoice;
}

public Customer(){
	
}
public Customer(long custId, String compName, String address,
		String emailAddress, String password, String telNo,
		String paymentMethod, Set<OrderItem> orderline) {
	super();
	CustId = custId;
	this.compName = compName;
	Address = address;
	this.emailAddress = emailAddress;
	Password = password;
	this.telNo = telNo;
	this.paymentMethod = paymentMethod;
	this.orderline = orderline;
}

public Customer(String compName, String address, String emailAddress,String Password,
		String telNo, String paymentMethod) {
	super();

	this.compName = compName;
	Address = address;
	this.emailAddress = emailAddress;
	this.telNo = telNo;
	this.paymentMethod = paymentMethod;
	this.Password=Password;
}
// take it up
public Customer(long custId,String compName, String address, String emailAddress,
		String password, String telNo, String paymentMethod) {
	super();
	CustId = custId;
	this.compName = compName;
	Address = address;
	this.emailAddress = emailAddress;
	Password = password;
	this.telNo = telNo;
	this.paymentMethod = paymentMethod;
	
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public long getCustId() {
	return CustId;
}

public void setCustId(long custId) {
	CustId = custId;
}

public String getCompName() {
	return compName;
}

public void setCompName(String compName) {
	this.compName = compName;
}

public String getAddress() {
	return Address;
}

public List<Delivery> getDelivery() {
	return delivery;
}

public void setDelivery(List<Delivery> delivery) {
	this.delivery = delivery;
}


public void setAddress(String address) {
	Address = address;
}


public String getEmailAddress() {
	return emailAddress;
}

public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

public String getTelNo() {
	return telNo;
}

public void setTelNo(String telNo) {
	this.telNo = telNo;
}

public String getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}


}

