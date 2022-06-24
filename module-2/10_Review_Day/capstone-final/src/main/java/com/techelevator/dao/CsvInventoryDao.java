package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.Map;

public class CsvInventoryDao implements InventoryDao {
    @Override
    public Map<String, Snack> getAll() {
        return Map.of("B1", new Drink("B1", "Coca-Cola", 1.0));
    }
}
