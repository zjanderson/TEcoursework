package com.techelevator.model;

public class ShoppingListItem {
    private int listItemId;
    private int listId;
    private String itemName;
    private boolean isCompleted;

    public int getListItemId() {
        return listItemId;
    }

    public void setListItemId(int listItemId) {
        this.listItemId = listItemId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
