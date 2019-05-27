package com.eshopping.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.eshopping.dao.OrdersDao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Order {
	
	private String orderId;
	
	private List<ItemRequest> itemList;
	
	@NotNull
	private String emailId;
	
	private String address;
	
	private int phoneNumber;
	
	private float billingAmount;
	
	private Date orderTime;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(OrdersDao ordersDao) {
		ObjectMapper om = new ObjectMapper();
		this.orderId = ordersDao.getOrderId();
		try {
			this.itemList = om.readValue(ordersDao.getItemsListDoc(), new TypeReference<ArrayList<Item>>(){});
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.emailId = ordersDao.getEmailId();
		this.address = ordersDao.getAddress();
		this.phoneNumber = ordersDao.getPhoneNumber();
		this.billingAmount = ordersDao.getBillingAmount();
		this.orderTime = ordersDao.getOrderTime();
	}
	
	public float getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(float billingAmount) {
		this.billingAmount = billingAmount;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<ItemRequest> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemRequest> itemList) {
		this.itemList = itemList;
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
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
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
		Order other = (Order) obj;
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
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
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
		return "Order [orderId=" + orderId + ", itemList=" + itemList + ", emailId=" + emailId + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", billingAmount=" + billingAmount + ", orderTime=" + orderTime
				+ "]";
	}

}
