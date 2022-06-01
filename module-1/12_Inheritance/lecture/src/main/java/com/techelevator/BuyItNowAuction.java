package com.techelevator;

public class BuyItNowAuction extends Auction {

    private int buyItNowPrice;
    private boolean isBuyItNowPrice = false;

    public BuyItNowAuction(String itemForSale, int buyItNowPrice) {
        super(itemForSale);
        this.buyItNowPrice = buyItNowPrice;
    }

 //   @Override
  //  public boolean placeBid(Bid offeredBid) {
        //you can place a bid, and wait for auction to end to see if you won
        //can also bid the buyItNowPrice and win auction immediately

 //       return super.placeBid(offeredBid);

 //       if (offeredBid.getBidAmount() >= buyItNowPrice) {
 //           isBuyItNowPrice = true;
 //       }
  //      return false;
 //   }



}
