package com.eshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.dao.ItemsDao;
import com.eshopping.dao.ItemsRepository;
import com.eshopping.dao.OrdersDao;
import com.eshopping.dao.OrdersRepository;
import com.eshopping.dto.Item;
import com.eshopping.dto.Order;

@Service
public class OrderServiceImplementation implements OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Autowired
	private ItemService itemService;

	@Override
	public Object placeOrder(Order order) {
		boolean validOrder = true;
		List<Item> items = order.getItemList();
		List<ItemsDao> itemsDao = new ArrayList<>();
		for(Item item:items) {
			if(item.getQuantity() > itemsRepository.getOne(item.getItemId()).getQuantity()) {
				validOrder = false;
				break;
			}
		}
		if(validOrder) {
			for(Item item:items) {
				//itemsRepository.
			}
		}
		OrdersDao orderDao = new OrdersDao(order);
		return new Order(ordersRepository.save(orderDao));
	}

	@Override
	public Object getAllOrders() {
		List<OrdersDao> ordersDao = ordersRepository.findAll();
		List<Order> orders = new ArrayList<Order>();
		for(OrdersDao orderDao:ordersDao) {
			orders.add(new Order(orderDao));
		}
		return orders;
	}

	@Override
	public Object getOrderDetails(String orderId) {
		return ordersRepository.findOne(orderId);
	}

}
