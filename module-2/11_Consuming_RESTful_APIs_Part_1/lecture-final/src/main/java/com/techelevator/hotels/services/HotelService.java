package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Activity;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        String url = API_BASE_URL + "hotels";

        Hotel[] allHotels = restTemplate.getForObject(url, Hotel[].class);

        return allHotels;
    }

    public Review[] listReviews() {
        // http://localhost:3000/reviews
        String url = API_BASE_URL + "reviews";

        Review[] reviews = restTemplate.getForObject(url, Review[].class);

        return reviews;
    }

    public Hotel getHotelById(int id) {
        // http://localhost:3000/hotels/:id

        String url = API_BASE_URL + "hotels/" + id;

        return restTemplate.getForObject(url, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        // http://localhost:3000/reviews?hotelID=:hotelID
        // http://localhost:3000/hotels/:hotelID/reviews

        String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";

        return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        // http://localhost:3000/hotels?stars=3

        String url = API_BASE_URL + "hotels?stars=" + stars;

        return restTemplate.getForObject(url, Hotel[].class);
    }

    public Activity getActivityOfType(String type) {
        String url = "http://www.boredapi.com/api/activity?type=" + type;

        return restTemplate.getForObject(url, Activity.class);
    }
}
