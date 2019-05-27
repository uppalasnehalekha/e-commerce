package com.eshopping.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eshopping.dto.Item;

@Entity
@Table(name = "Items")
public class ItemsDao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "itemId", nullable = false, updatable = false, unique = true)
	private String itemId;
	
	//@NotNull
	@Column(name = "itemName", nullable = false)
	private String itemName;
	
	//@NotNull
	@Column(name = "itemCost", nullable = false)
	private int itemCost;
	
	//@NotNull
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	public ItemsDao(Item item) {
		this.itemId = item.getItemId();
		this.itemName = item.getItemName();
		this.itemCost = item.getItemCost();
		this.quantity = item.getQuantity();
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
		ItemsDao other = (ItemsDao) obj;
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
		return "ItemDao [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + ", quantity=" + quantity
				+ "]";
	}
	
}
