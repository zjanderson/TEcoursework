package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.ArrayList;
import java.util.List;

public class HardCodedCityDao implements CityDao {
    @Override
    public City getCity(int cityId) {
        return new City();
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        return new ArrayList<>();
    }

    @Override
    public City createCity(City city) {
        return new City();
    }

    @Override
    public void updateCity(City city) {

    }

    @Override
    public void deleteCity(int cityId) {

    }
}
