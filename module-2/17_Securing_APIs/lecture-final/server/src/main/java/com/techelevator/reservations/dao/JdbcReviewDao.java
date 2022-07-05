package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {
    private final HotelDao hotelDao;
    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(HotelDao hotelDao, JdbcTemplate jdbcTemplate) {
        this.hotelDao = hotelDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getReviewsForUser(int userId) {
        List<Review> reviews = new ArrayList<>();

        String sql = "" +
                "SELECT review_id, hotel_id, title, author, description, stars " +
                "FROM review " +
                "WHERE user_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            Review review = mapRowToReview(rowSet);

            reviews.add(review);
        }

        return reviews;
    }

    @Override
    public Review create(Review review) throws HotelNotFoundException {
        // check if hotel exists
        hotelDao.get(review.getHotelId());

        String sql = "" +
                "INSERT INTO review (hotel_id, title, author, description, stars) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING review_id;";

        Integer reviewId = jdbcTemplate.queryForObject(sql, Integer.class,
                review.getHotelId(),
                review.getTitle(),
                review.getAuthor(),
                review.getDescription(),
                review.getStars());

        return getReviewById(reviewId);
    }

    private Review getReviewById(int reviewId) {
        String sql = "" +
                "SELECT review_id, hotel_id, title, author, description, stars " +
                "FROM review " +
                "WHERE review_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, reviewId);

        if (rowSet.next()) {
            return mapRowToReview(rowSet);
        }

        return null;
    }

    @Override
    public List<Review> getReviewsForHotel(int hotelId) {
        List<Review> reviews = new ArrayList<>();

        String sql = "" +
                "SELECT review_id, hotel_id, title, author, description, stars " +
                "FROM review " +
                "WHERE hotel_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, hotelId);

        while (rowSet.next()) {
            Review review = mapRowToReview(rowSet);

            reviews.add(review);
        }

        return reviews;
    }

    @Override
    public void updateReview(int reviewId) {
        if (reviewId < 0) throw new RuntimeException();

        String sql = "UPDATE review SET title = title + '. updated!' WHERE reviewId = ?;";

        jdbcTemplate.update(sql, reviewId);
    }

    private Review mapRowToReview(SqlRowSet rowSet) {
        Review review = new Review();
        review.setId(rowSet.getInt("review_id"));
        review.setHotelId(rowSet.getInt("hotel_id"));
        review.setTitle(rowSet.getString("title"));
        review.setAuthor(rowSet.getString("author"));
        review.setDescription(rowSet.getString("description"));
        review.setStars(rowSet.getInt("stars"));
        return review;
    }
}
