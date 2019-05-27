package com.eshopping.service;

import com.eshopping.dto.Order;

public interface OrderService {

	public Object placeOrder(Order order);
	
	public Object getAllOrders();
	
	public Object getOrderDetails(String orderId);
}
