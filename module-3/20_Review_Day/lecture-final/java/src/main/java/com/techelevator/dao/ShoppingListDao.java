package com.techelevator.dao;

import com.techelevator.model.ShoppingList;

import java.util.List;

public interface ShoppingListDao {

    List<ShoppingList> getAllForUser(int userId);
}
