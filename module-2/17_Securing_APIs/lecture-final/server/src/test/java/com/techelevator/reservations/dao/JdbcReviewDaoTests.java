package com.techelevator.reservations.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcReviewDaoTests extends BaseDaoTests {
    private JdbcReviewDao jdbcReviewDao;

    @Before
    public void setup() {
        this.jdbcReviewDao = new JdbcReviewDao(new FakeHotelDao(), new JdbcTemplate(dataSource));
    }

    @Test
    public void getReviewsForHotel_returns_one() {
        // Arrange

        // Act

        // Assert
    }
}
