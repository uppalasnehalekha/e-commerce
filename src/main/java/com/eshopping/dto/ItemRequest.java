package com.eshopping.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.eshopping.dao.ItemsDao;

public class ItemRequest {
	
	@NotNull
	private String itemId;
	
	@NotNull
	@Min(value = 1,message="must be positive")
	private int quantity;
	
	public ItemRequest() {
		super();
	}
	
	public ItemRequest(String itemId, String itemName, int quantity, int itemCost) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public ItemRequest(ItemsDao itemsDao) {
		this.itemId = itemsDao.getItemId();
		this.quantity = itemsDao.getQuantity();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		ItemRequest other = (ItemRequest) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemRequest [itemId=" + itemId + ", quantity=" + quantity + "]";
	}

	
}
