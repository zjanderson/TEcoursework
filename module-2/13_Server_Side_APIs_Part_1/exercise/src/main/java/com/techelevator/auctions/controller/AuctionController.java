package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auctions")  //http://localhost8080/auctions is what all our requests start with
public class AuctionController {             //ALL WORK IS DONE HERE

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

}
