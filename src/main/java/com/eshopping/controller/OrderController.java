package com.eshopping.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.dto.Order;
import com.eshopping.service.OrderService;

@RestController
public class OrderController implements OrderApi{
	
	@Autowired
	private OrderService orderService;
	
	private final HttpServletRequest request;
	
	public OrderController(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ResponseEntity<Object> placeOrder(@RequestBody Order order) {
		Object object = orderService.placeOrder(order);
		if(object instanceof Order) {
			 Order response = (Order)object;
			return ResponseEntity.created(URI.create("http://"+this.request.getLocalName()+":"+this.request.getLocalPort()+"?orderId="+response.getOrderId())).body(response);
		}
		return ResponseEntity.unprocessableEntity().body(object);
	}	
		
	@Override
	public ResponseEntity<Object> getOrderDetails(@RequestParam(value = "orderId", required = false) String orderId) {
		if(orderId == null) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderService.getAllOrders());
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderService.getOrderDetails(orderId));
	}

}
