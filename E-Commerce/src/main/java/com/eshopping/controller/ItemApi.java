package com.eshopping.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshopping.dto.Item;

public interface ItemApi {
	
	@GetMapping(value = "/items",
			produces = {"application/json"})
	ResponseEntity<Object> getItemById(@RequestParam(value = "itemId", required = false) String itemId);
	
	@PutMapping(value = "/updateItem",
			produces = {"application/json"},
			consumes = {"application/json"})
	ResponseEntity<Object> updateItemDetails(@RequestBody Item item);

	@PostMapping(value = "/addItems",
			produces = {"application/json"},
			consumes = {"application/json"})
	ResponseEntity<Object> addItems(@RequestBody List<Item> items);
	
	@DeleteMapping(value = "/deleteItem")
	ResponseEntity<Object> deleteItem(@RequestParam("itemId") String itemId);
}
