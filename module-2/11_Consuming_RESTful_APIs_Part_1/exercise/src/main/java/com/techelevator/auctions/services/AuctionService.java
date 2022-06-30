package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {          // the entire homework is done in this class

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        String url = API_BASE_URL;
        Auction[] allAuctions = restTemplate.getForObject(url, Auction[].class);
        return allAuctions;
    }

    public Auction getAuction(int id) {
        String url = API_BASE_URL + id;
        return restTemplate.getForObject(url, Auction.class);
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        String url = API_BASE_URL + "?title_like=" + title;
        Auction[] auctionsByTitle = restTemplate.getForObject(url, Auction[].class);
        return auctionsByTitle;

    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        String url = API_BASE_URL + "?currentBid_lte=" + price;
        Auction[] auctionsUnderPrice = restTemplate.getForObject(url, Auction[].class);
        return auctionsUnderPrice;

    }

}
