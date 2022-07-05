package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.ReviewDao;
import com.techelevator.reservations.dao.UserDao;
import com.techelevator.reservations.model.Review;
import com.techelevator.reservations.security.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class ReviewController {

    private ReviewDao reviewDao;
    private UserDao userDao;

    public ReviewController(ReviewDao reviewDao, UserDao userDao) {
        this.reviewDao = reviewDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getReviewsForUser(Principal principal) {
        String username = principal.getName();
        int userId = userDao.getUserIdForUsername(username);

        return reviewDao.getReviewsForUser(userId);
    }

    @Transactional
    @RequestMapping(path = "/reviews/testing", method = RequestMethod.PUT)
    public void updateReviews() {
        reviewDao.updateReview(1);
        reviewDao.updateReview(2);
    }

}
