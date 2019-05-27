package com.eshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping.dao.ItemsDao;
import com.eshopping.dao.ItemsRepository;
import com.eshopping.dto.Item;

@Service
public class ItemServiceImplementation implements ItemService {
	
	@Autowired
	private ItemsRepository itemsRepository;

	@Override
	public Object getAllItems() {
		List<ItemsDao> itemsDao = itemsRepository.findAll();
		List<Item> items = new ArrayList<Item>();
		for(ItemsDao itemDao:itemsDao) {
			items.add(new Item(itemDao));
		}
		return items;
	}

	@Override
	public Object getItemById(String itemId) {
		ItemsDao itemDao = itemsRepository.findOne(itemId);
		if(itemDao != null) {
			return new Item(itemDao);
		}
		return null;
	}

	@Override
	public Object updateItemDetails(Item item) {
		return new Item(itemsRepository.save(new ItemsDao(item)));
	}

	@Override
	public Object addItems(List<Item> items) {
		for(Item item:items) {
			this.updateItemDetails(item);
		}
		return items.size();
	}

	@Override
	public void deleteItem(String itemId) {
		itemsRepository.delete(itemId);
	}

}
