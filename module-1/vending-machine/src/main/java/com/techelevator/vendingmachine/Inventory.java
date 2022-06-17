package com.techelevator.vendingmachine;

import java.util.Map;

public interface Inventory {
	void restock();

	Map<String, Slot> getInventory();
}
