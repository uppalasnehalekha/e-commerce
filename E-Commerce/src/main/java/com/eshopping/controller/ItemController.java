package com.eshopping.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.dto.Item;
import com.eshopping.service.ItemService;

@RestController
public class ItemController implements ItemApi{
	
	@Autowired
	private ItemService itemService;

	/*@Override
	public ResponseEntity<Object> getAllItems() {
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(itemService.getAllItems());
	}*/

	@Override
	public ResponseEntity<Object> getItemById(String itemId) {
		Object response = itemService.getItemById(itemId);
		if(response == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body((Item)response);
	}

	@Override
	public ResponseEntity<Object> updateItemDetails(Item item) {
		Object response = itemService.updateItemDetails(item);
		if(response == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body((Item)response);
	}

	@Override
	public ResponseEntity<Object> addItems(ArrayList<Item> items) {
		System.out.println(items);
		Iterator<Item> iter = items.iterator();
		int count = 0;
		while(iter.hasNext()) {
			itemService.updateItemDetails(iter.next());
			count++;
		}
		//int count = (int)itemService.addItems(items);
		return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(""+count+" items have been added");
	}

	@Override
	public ResponseEntity<Object> deleteItem(String itemId) {
		itemService.deleteItem(itemId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	
}
