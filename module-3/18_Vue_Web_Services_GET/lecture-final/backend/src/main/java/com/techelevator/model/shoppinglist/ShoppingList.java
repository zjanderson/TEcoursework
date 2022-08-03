package com.techelevator.model.shoppinglist;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private List<String> items = new ArrayList<>();

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void addItem(String item) {
        items.add(item);
    }
}
