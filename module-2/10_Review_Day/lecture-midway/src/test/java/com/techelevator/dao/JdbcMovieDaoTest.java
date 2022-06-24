package com.techelevator.dao;

import org.junit.Before;
import org.junit.Test;

public class JdbcMovieDaoTest extends BaseDaoTests {
    private JdbcMovieDao jdbcMovieDao;

    @Before
    public void setup() {
        jdbcMovieDao = new JdbcMovieDao(dataSource);
    }

    @Test
    public void create_returns_movie_with_data() {
        // Arrange

        // Act

        // Assert
    }
}
