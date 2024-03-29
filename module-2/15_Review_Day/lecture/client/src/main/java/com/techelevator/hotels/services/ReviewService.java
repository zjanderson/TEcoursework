package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Review;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ReviewService {

    private final RestTemplate restTemplate= new RestTemplate();
    private static final String API_BASE_URL = "http://localhost:8080";

    public Review[] getReviewsForHotel(int hotelId) {
        String url = API_BASE_URL + "/hotels/" + hotelId + "/reviews";
        try {
            Review[] reviews = restTemplate.getForObject(url, Review[].class);
            return reviews;

        } catch (RestClientResponseException e) {

        } catch (ResourceAccessException e) {

        }
        return null;
    }
}
