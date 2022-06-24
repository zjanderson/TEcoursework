package com.techelevator.dao;

import com.techelevator.model.Snack;

import java.util.Map;

public interface InventoryDao {
    Map<String, Snack> getAll();
}
