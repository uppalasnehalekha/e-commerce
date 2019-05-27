package com.eshopping.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.eshopping.dao.ItemsDao;

public class Item {
	
	private String itemId;
	
	@NotNull
	private String itemName;
	
	@NotNull
	@Min(value = 1,message="must be positive")
	private int quantity;
	
	@NotNull
	@Min(value = 1, message = "must be positive")
	private int itemCost;
	
	public Item() {
		super();
	}
	
	public Item(String itemId, String itemName, int quantity, int itemCost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.itemCost = itemCost;
	}



	public Item(ItemsDao itemsDao) {
		this.itemId = itemsDao.getItemId();
		this.itemName = itemsDao.getItemName();
		this.itemCost = itemsDao.getItemCost();
		this.quantity = itemsDao.getQuantity();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemCost;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemCost != other.itemCost)
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + ", quantity=" + quantity
				+ "]";
	}
	
}
