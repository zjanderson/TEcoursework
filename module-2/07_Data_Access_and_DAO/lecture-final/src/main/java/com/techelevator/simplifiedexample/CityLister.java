package com.techelevator.simplifiedexample;


import com.techelevator.dao.JdbcStateDao;
import com.techelevator.model.City;
import com.techelevator.model.State;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class CityLister {
    public static void main(String[] args) {
        // 1. Define the data source we will connect to.
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        JdbcStateDao dao = new JdbcStateDao(dataSource);
        State california = dao.getState("CA");



        // 2. Write our query and execute it

        String stateAbbreviation = "CA";

        String sql = "SELECT city_id, city_name, population FROM city WHERE state_abbreviation = ? AND population > ?;";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, stateAbbreviation, 1000);

        // 3. Process results
        List<City> citiesInCaliforniaWithAtLeast1000 = new ArrayList<>();

        /*

     ->   45	"Carlsbad"	    115382
         62	"Chico"	        103301
        63	"Chula Vista"	274492
         */
        while (rowSet.next()) {
            int cityId = rowSet.getInt("city_id");
            String cityName = rowSet.getString("city_name");
            int population = rowSet.getInt("population");

            City city = new City();
            city.setCityId(cityId);
            city.setCityName(cityName);
            city.setPopulation(population);
            city.setStateAbbreviation("CA");

            citiesInCaliforniaWithAtLeast1000.add(city);
        }


//        jdbcTemplate.queryForObject()
//        jdbcTemplate.update()
    }
}
