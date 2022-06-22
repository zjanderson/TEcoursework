package com.techelevator.simplifiedexample;

import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class CityLister {
    public static void main(String[] args) {
        // 1. definite data source we will connect to.
        BasicDataSource datasource = new BasicDataSource();
        datasource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        datasource.setUsername("postgres");
        datasource.setPassword("postgres1");

        //2. Write query and execute

        String stateAbbreviation = "CA";
        String sql = "SELECT city_id, city_name, population FROM city WHERE state_abbreviation = ? AND population > ?;";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);

//        jdbcTemplate.queryForRowSet()  -- this gives us a whole row of data from a table
//        jdbcTemplate.queryForObject()  -- this gives us the value in one cell
//        jdbcTemplate.update()  -- this doesn't return anything, it just performs an action

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, stateAbbreviation, 1000);  //queryForRowset takes in the query we want to run (sql), and enough data to satisfy any ? in query

        // 3. Process results
        List<City> citiesInCaliforniaWithAtLeast1000 = new ArrayList<>();
        while (rowSet.next()) {

            int cityId =  rowSet.getInt("city_id"); // two step method, make this var and plug into setter below

            City city = new City();
            city.setCityId(cityId);
            city.setCityName(rowSet.getString("city_name"));  //one step method, just use the getter to set this
            city.setPopulation(rowSet.getInt("population"));
            city.setStateAbbreviation("CA");

            citiesInCaliforniaWithAtLeast1000.add(city);


        }

    }
}
