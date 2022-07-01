package com.techelevator.auctions.controller;

import java.util.List;

import com.techelevator.auctions.exception.AuctionNoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.exception.AuctionNotFoundException;
import com.techelevator.auctions.model.Auction;

import javax.validation.Valid;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

	@Autowired
    private AuctionDao dao;

    public AuctionController(AuctionDao dao) {
        this.dao = dao;
    }

    @RequestMapping( path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {

        if( !title_like.equals("") ) {
            return dao.searchByTitle(title_like);
        }
        if(currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        }

        return dao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) throws AuctionNotFoundException {
        return dao.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "", method = RequestMethod.POST)
    public Auction create(@Valid @RequestBody Auction auction) {
        return dao.create(auction);
    }

    @RequestMapping(path = "/{auctionId}", method = RequestMethod.PUT)
    public Auction update(@PathVariable int auctionId,
                          @Valid @RequestBody Auction auction) throws AuctionNotFoundException {
        auction.setId(auctionId);

        return dao.update(auction, auctionId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{auctionId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int auctionId) throws AuctionNotFoundException {
        dao.delete(auctionId);
    }


}
