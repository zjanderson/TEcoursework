package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.Map;

public class HardCodeInventoryDao implements InventoryDao {
    @Override
    public Map<String, Snack> getAll() {
        return Map.of("A1", new Chip("A1", "Fritos", 1.5), "A2", new Chip("A2", "Cheetos", 2.5));
    }
}
