package com.eshopping.service;

import java.util.List;

import com.eshopping.dto.Item;

public interface ItemService {
	
	public Object getAllItems();
	
	public Object getItemById(String itemId);
	
	public Object updateItemDetails(Item item);
	
	public Object addItems(List<Item> items);
	
	public void deleteItem(String itemId);

}
