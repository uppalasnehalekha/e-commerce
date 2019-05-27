package com.eshopping.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.dao.ItemsDao;
import com.eshopping.dao.ItemsRepository;
import com.eshopping.dao.OrdersDao;
import com.eshopping.dao.OrdersRepository;
import com.eshopping.dto.Item;
import com.eshopping.dto.ItemRequest;
import com.eshopping.dto.Order;

@Service
public class OrderServiceImplementation implements OrderService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private ItemsRepository itemsRepository;
	
	@Autowired
	private ItemService itemService;

	
	private float calculateBillingAmount(List<ItemRequest> items) {
		float total = 0;
		Item it;
		for(ItemRequest item:items) {
			it = (Item)itemService.getItemById(item.getItemId());
			total += it.getItemCost() * item.getQuantity();
		}
		return total;
	}
	
	private void decreaseItemQuantity(ItemRequest itemRequest) {
		Item item = (Item)itemService.getItemById(itemRequest.getItemId());
		item.setQuantity(item.getQuantity() - itemRequest.getQuantity());
		itemService.updateItemDetails(item);
	}
	
	@Override
	public Object placeOrder(Order order) {
		List<ItemRequest> items = order.getItemList();
		ItemsDao item1;
		for(ItemRequest item:items) {
			item1 = itemsRepository.getOne(item.getItemId());
			if(item1.getQuantity() == 0) {
				return item1.getItemName()+" Out of Stock";
			}else if(item.getQuantity() > item1.getQuantity()) {
				return "Only "+item1.getQuantity()+" "+item1.getItemName()+" are available";
			}else if(item.getQuantity() < 0) {
				return "Order quantity should be postive";
			}
		}
		items.forEach(item -> decreaseItemQuantity(item));
		order.setOrderTime(new Date());
		order.setBillingAmount(this.calculateBillingAmount(items));
		OrdersDao orderDao = new OrdersDao(order);
		return  new Order(ordersRepository.save(orderDao));
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
