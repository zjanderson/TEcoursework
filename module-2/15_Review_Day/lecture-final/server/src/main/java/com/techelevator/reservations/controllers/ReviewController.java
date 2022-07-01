package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.ReviewDao;
import com.techelevator.reservations.exception.HotelNotFoundException;
import com.techelevator.reservations.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReviewController {
    private final ReviewDao dao;

    public ReviewController(ReviewDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/hotels/{hotelId}/reviews", method = RequestMethod.GET)
    public List<Review> getReviewsForHotel(@PathVariable int hotelId) {
        return dao.getReviewsForHotel(hotelId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review createReview(@Valid @RequestBody Review review) throws HotelNotFoundException {
        return dao.create(review);
    }
}
