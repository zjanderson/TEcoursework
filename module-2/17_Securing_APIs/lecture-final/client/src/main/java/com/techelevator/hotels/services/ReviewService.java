package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Review;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class ReviewService {
    private RestTemplate restTemplate = new RestTemplate();
    private String authToken;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Review[] getReviewsForUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {

           ResponseEntity<Review[]> response = restTemplate.exchange("http://localhost:8080/reviews", HttpMethod.GET, entity, Review[].class);
           if (response.hasBody()) {
               return response.getBody();
           }

        } catch (RestClientResponseException | ResourceAccessException e) {

        }

        return null;
    }
}
