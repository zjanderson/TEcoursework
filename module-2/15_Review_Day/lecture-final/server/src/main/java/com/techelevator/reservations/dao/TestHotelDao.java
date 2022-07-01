package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.model.Hotel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("test")
public class TestHotelDao implements HotelDao {

    @Override
    public List<Hotel> list() {
        return null;
    }

    @Override
    public void create(Hotel hotel) {

    }

    @Override
    public Hotel get(int id) throws HotelNotFoundException {
        return null;
    }
}
