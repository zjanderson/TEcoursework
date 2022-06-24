package com.techelevator;

import com.techelevator.dao.InventoryDao;
import com.techelevator.model.Snack;

import java.util.Map;

public class VendingMachine {
    private Map<String, Snack> inventory;
    private final InventoryDao inventoryDao;

    public VendingMachine(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
        restock();
    }

    public void restock() {
        inventory = inventoryDao.getAll();
    }

}
