package com.techelevator.dao;

import com.techelevator.model.ShoppingList;
import com.techelevator.model.ShoppingListItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcShoppingListDao implements ShoppingListDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcShoppingListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ShoppingList> getAllForUser(int userId) {
        List<ShoppingList> shoppingLists = new ArrayList<>();

        String sql = "SELECT * FROM list WHERE user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
        while (rowSet.next()) {
            ShoppingList list = mapRowToShoppingList(rowSet);

            list.setItems((getgetItemsForList(list.getListId())));

            shoppingLists.add(list);
        }
        return shoppingLists;
    }

    private List<ShoppingListItem> getgetItemsForList(int listId) {
        List<ShoppingListItem> items = new ArrayList<>();

        String sql = "SELECT * FROM list_item WHERE list_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, listId);

        while (rowSet.next()) {
            ShoppingListItem item = mapRowToItem(rowSet);

            items.add(item);
        }

        return items;
    }

    private ShoppingListItem mapRowToItem(SqlRowSet rowSet) {
        ShoppingListItem myItem = new ShoppingListItem();

        myItem.setListId(rowSet.getInt("list_id"));
        myItem.setListItemId(rowSet.getInt("list_item_id"));
        myItem.setItemName(rowSet.getString("item_name"));
        myItem.setCompleted(rowSet.getBoolean("is_completed"));

        return myItem;
    }

    private ShoppingList mapRowToShoppingList(SqlRowSet rowSet) {
        ShoppingList myList = new ShoppingList();

        myList.setListId(rowSet.getInt("list_id"));
        myList.setUserId(rowSet.getInt("user_id"));
        myList.setName(rowSet.getString("name"));

        return myList;
    }
}
