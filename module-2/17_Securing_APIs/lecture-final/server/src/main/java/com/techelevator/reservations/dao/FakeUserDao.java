package com.techelevator.reservations.dao;

import org.springframework.stereotype.Component;

@Component
public class FakeUserDao implements UserDao {


    @Override
    public int getUserIdForUsername(String username) {
        if (username.equals("user")) return 1;

        if (username.equals("admin")) return 2;

        return -1;
    }
}
