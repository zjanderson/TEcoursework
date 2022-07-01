package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/auctions")  //http://localhost8080/auctions is what all our requests start with
public class AuctionController {             //ALL WORK IS DONE HERE

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    /*
    List to return all auctions
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "") String title_like,
                              @RequestParam(required = false, defaultValue = "0") double currentBid_lte) {

        List<Auction> auctions = dao.list();

        //if we get no parameters passed in, return the normal list
        if (title_like.equals("") && currentBid_lte == 0) {
            return auctions;
        }

        //if we get a title passed in, but no currentBid
        if (currentBid_lte == 0) {
            List<Auction> searchByTitle = dao.searchByTitle(title_like);

//            for (Auction auction : auctions) {
//                if (auction.getTitle().toLowerCase().contains(title_like)) {
//                    filteredAuctions.add(auction);
//                }
//            }
            return searchByTitle;
        }

        //if we get a currentBid, but no title
        if (title_like.equals("")) {
            List<Auction> searchByPrice = dao.searchByPrice(currentBid_lte);

//            for (Auction auction : auctions) {
//                if (auction.getCurrentBid() <= currentBid_lte) {
//                    filteredAuctions.add(auction);
//                }
//            }
            return searchByPrice;
        }

        //if we get a title and a currentBid
        List<Auction> searchByTitleAndPrice = dao.searchByTitleAndPrice(title_like, currentBid_lte);
//
//        for (Auction auction : auctions) {
//            if (auction.getCurrentBid() <= currentBid_lte
//                && auction.getTitle().toLowerCase().contains(title_like)) {
//                filteredAuctions.add(auction);
//            }
//        }

        return searchByTitleAndPrice;
    }

    /*
    method named get() that accepts an int and returns an Auction
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    /*
     add the auction that's passed to it
     */
    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction createdAuction) {
        dao.create(createdAuction);

        return dao.get(createdAuction.getId());
    }


}
