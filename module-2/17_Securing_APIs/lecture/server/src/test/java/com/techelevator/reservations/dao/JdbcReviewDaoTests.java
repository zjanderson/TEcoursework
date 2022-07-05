package com.techelevator.reservations.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class JdbcReviewDaoTests extends BaseDaoTests {
    private JdbcReviewDao jdbcReviewDao;

    @Autowired
    private HotelDao fakeHotelDao;

    @Before
    public void setup() {
        this.jdbcReviewDao = new JdbcReviewDao(fakeHotelDao, new JdbcTemplate(dataSource));
    }

    @Test
    public void getReviewsForHotel_returns_one() {
        // Arrange

        // Act

        // Assert
    }
}
