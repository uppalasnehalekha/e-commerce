package com.eshopping.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.dto.Item;
import com.eshopping.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ItemController implements ItemApi{
	
	@Autowired
	private ItemService itemService;
	
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	
	@Autowired
	public ItemController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<Object> getItemById(@RequestParam(value = "itemId", required = false) String itemId) {
		Object response;
		if(itemId == null) {
			response = itemService.getAllItems();
		}else {
			response = itemService.getItemById(itemId);
			if(response == null) {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@Override
	public ResponseEntity<Object> updateItemDetails(@RequestBody Item item) {
		Object response = itemService.updateItemDetails(item);
		if(response == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body((Item)response);
	}

	@Override
	public ResponseEntity<Object> addItems(@RequestBody List<Item> items) {
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
	public ResponseEntity<Object> deleteItem(@RequestParam("itemId") String itemId) {
		itemService.deleteItem(itemId);
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	
}
