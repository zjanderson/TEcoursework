package com.techelevator;

public class BuyItNowAuction extends Auction {
    private final int buyItNowPrice;
    private boolean isBuyItNowPriceMet = false;

    public BuyItNowAuction(String itemForSale, int buyItNowPrice) {
        super(itemForSale);
        this.buyItNowPrice = buyItNowPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        if (isAuctionEnded()) {
            return false;
        }

        if (offeredBid.getBidAmount() >= buyItNowPrice) {
            isBuyItNowPriceMet = true;
            Bid adjustedBid = new Bid(offeredBid.getBidder(), buyItNowPrice);
            return super.placeBid(adjustedBid);
        }

        return super.placeBid(offeredBid);
    }

    @Override
    public boolean isAuctionEnded() {
        return isBuyItNowPriceMet || super.isAuctionEnded();
    }
}
