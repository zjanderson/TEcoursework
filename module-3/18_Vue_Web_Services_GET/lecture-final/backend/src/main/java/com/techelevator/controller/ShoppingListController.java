package com.techelevator.controller;

import com.techelevator.model.shoppinglist.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
public class ShoppingListController {

    @RequestMapping(path = "/shopping-list", method = RequestMethod.GET)
    public ShoppingList getList() {

        ShoppingList shoppingList = new ShoppingList();

        shoppingList.addItem("Bread");
        shoppingList.addItem("Milk");
        shoppingList.addItem("Eggs");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No board with that id.");

//        return shoppingList;
    }
}
