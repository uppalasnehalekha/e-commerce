package com.eshopping.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.eshopping.dto.Order;

@Entity
@Table(name = "Orders")
public class OrdersDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private String orderId;
	
	@NotNull
	@Column(name = "itemsListDoc", columnDefinition = "json")
	private String itemsList;
	
	@NotNull
	@Column(name = "emailId", nullable = false)
	private String emailId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phoneNumber")
	private int phoneNumber;

	public OrdersDao(Order order) {
		this.orderId = order.getOrderId();
		this.itemsList = order.getItemList().toString();
		this.emailId = order.getEmailId();
		this.address = order.getAddress();
		this.phoneNumber = order.getPhoneNumber();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getItemsList() {
		return itemsList;
	}

	public void setItemsList(String itemsList) {
		this.itemsList = itemsList;
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
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((itemsList == null) ? 0 : itemsList.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
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
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (itemsList == null) {
			if (other.itemsList != null)
				return false;
		} else if (!itemsList.equals(other.itemsList))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdersDao [orderId=" + orderId + ", itemsList=" + itemsList + ", emailId=" + emailId + ", address="
				+ address + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
