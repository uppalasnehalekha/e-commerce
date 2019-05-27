package com.eshopping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshopping.dto.Order;

public interface OrderApi {
	
	@PostMapping(value = "/placeOrder",
			produces = {"application/json"},
			consumes = {"application/json"})
	ResponseEntity<Object> placeOrder(@RequestBody Order order);
	
	@GetMapping(value = "/getOrders",
			produces = {"application/json"})
	ResponseEntity<Object> getAllOrders();
	
	@GetMapping(value = "/getOrderDetails",
			produces = {"application/json"})
	ResponseEntity<Object> getOrderDetails(@RequestParam String orderId);

}
