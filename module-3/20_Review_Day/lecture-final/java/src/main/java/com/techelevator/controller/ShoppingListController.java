package com.techelevator.controller;

import com.techelevator.dao.ShoppingListDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.ShoppingList;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ShoppingListController {
    private final ShoppingListDao shoppingListDao;
    private final UserDao userDao;

    public ShoppingListController(ShoppingListDao shoppingListDao, UserDao userDao) {
        this.shoppingListDao = shoppingListDao;
        this.userDao = userDao;
    }

    @GetMapping("/shopping-list")
    public List<ShoppingList> getAllForUser(Principal principal) {
        String username = principal.getName();
        User loggedInUser = userDao.findByUsername(username);

        return shoppingListDao.getAllForUser(loggedInUser.getId());
    }
}
