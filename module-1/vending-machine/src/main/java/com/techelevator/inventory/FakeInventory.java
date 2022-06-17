package com.techelevator.inventory;

import com.techelevator.vendingmachine.Inventory;
import com.techelevator.vendingmachine.Slot;

import java.util.Map;

public class FakeInventory implements Inventory {
	private final Map<String, Slot> inventory;

	public FakeInventory(Map<String, Slot> inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public void restock() {
		// do nothing
	}

	@Override
	public Map<String, Slot> getInventory() {
		 return inventory;
	}

}
