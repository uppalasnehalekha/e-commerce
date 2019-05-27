package com.eshopping.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eshopping.dto.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "Orders")
public class OrdersDao {

	@Id
	@NotNull
	@Column(name = "orderId", nullable = false, updatable = false, unique = true)
	private String orderId;
	
	@NotNull
	@Column(name = "itemsListDoc", columnDefinition = "json")
	private String itemsListDoc;
	
	@NotNull
	@Column(name = "emailId", nullable = false)
	private String emailId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;
	
	@Column(name = "orderTime")
	private Date orderTime;
	
	@Column(name = "billingAmount")
	private float billingAmount;
	
	public OrdersDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersDao(Order order) {
		ObjectMapper om = new ObjectMapper();
		this.orderId = order.getOrderId();
		try {
			this.itemsListDoc = om.writeValueAsString(order.getItemList());
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.emailId = order.getEmailId();
		this.address = order.getAddress();
		this.phoneNumber = order.getPhoneNumber();
		this.billingAmount = order.getBillingAmount();
		this.orderTime = order.getOrderTime();
		
	}
	
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public float getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(float billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemsListDoc() {
		return itemsListDoc;
	}

	public void setItemsListDoc(String itemsListDoc) {
		this.itemsListDoc = itemsListDoc;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Float.floatToIntBits(billingAmount);
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((itemsListDoc == null) ? 0 : itemsListDoc.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + phoneNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersDao other = (OrdersDao) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Float.floatToIntBits(billingAmount) != Float.floatToIntBits(other.billingAmount))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (itemsListDoc == null) {
			if (other.itemsListDoc != null)
				return false;
		} else if (!itemsListDoc.equals(other.itemsListDoc))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdersDao [orderId=" + orderId + ", itemsListDoc=" + itemsListDoc + ", emailId=" + emailId
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", orderTime=" + orderTime
				+ ", billingAmount=" + billingAmount + "]";
	}

}
