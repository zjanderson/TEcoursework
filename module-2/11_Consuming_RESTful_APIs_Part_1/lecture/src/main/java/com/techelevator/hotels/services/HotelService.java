package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {  ////the job of this class is to send requests to the server and bring back info to make objects

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        String url = API_BASE_URL + "hotels";

        Hotel[] allHotels = restTemplate.getForObject(url, Hotel[].class);  //getForObject is generic, so you have to specify that you expect a hotel array

        return allHotels;
    }

    public Review[] listReviews() {
        return null;
    }

    public Hotel getHotelById(int id) {
        //http://localhost:3000/hotels/:id

        String url = API_BASE_URL + "hotels/" + id;

        return restTemplate.getForObject(url,Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        //http://localhost:3000/reviews?hoteID=:hotelID


        String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
        return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {

        String url = API_BASE_URL + "hotels?stars/" + stars;

        return restTemplate.getForObject(url, Hotel[].class);
    }


}
