package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.model.Review;

import java.util.List;

public interface ReviewDao {

    Review create(Review review) throws HotelNotFoundException;

    List<Review> getReviewsForHotel(int hotelId);
}
