package com.techelevator;

import com.techelevator.dao.CityDao;
import com.techelevator.dao.HardCodedCityDao;
import com.techelevator.dao.JdbcCityDao;
import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class CityWorker {
    public static void main(String[] args) {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        CityDao dao = new HardCodedCityDao();

        doWork(dao);
    }

    public static void doWork(CityDao dao) {
        City city = new City();
        city.setCityName("Smallville");
        city.setStateAbbreviation("KS");
        city.setPopulation(1000);
        city.setArea(10.5);
        city = dao.createCity(city);

        List<City> allCitiesInKansas = dao.getCitiesByState("KS");
        for (City cityInKansas : allCitiesInKansas) {
            System.out.println(cityInKansas.getCityName());
        }

        dao.deleteCity(city.getCityId());
    }

}
