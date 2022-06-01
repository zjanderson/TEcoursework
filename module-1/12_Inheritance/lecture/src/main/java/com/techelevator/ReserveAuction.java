package com.techelevator;

public class ReserveAuction extends Auction {

    private final int reservePrice; //final means no setter needed


    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    //no getter, because the reserve is hidden from bidders

    //we need to Override the super placeBid because we need to check against the reservePRice first


    @Override
    public boolean placeBid(Bid offeredBid) {
        if (offeredBid.getBidAmount() >= reservePrice) {
            return super.placeBid(offeredBid);
        }
        return false;
    }
}
