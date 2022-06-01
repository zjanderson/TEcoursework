package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

      //  System.out.println(generalAuction.getHighBid());    <- this prints the MEMORY location, not the info contained
        System.out.println(generalAuction.getHighBid().getBidder());  //this will print out who won

        String whoWon = generalAuction.getHighBid().getBidder();
        String whatDidTheyWin = generalAuction.getItemForSale();
        int howMuchDidTheyPay = generalAuction.getHighBid().getBidAmount();

        System.out.println(whoWon + " won " + whatDidTheyWin + " by bidding $" + howMuchDidTheyPay);






        // Create a new reserve auction
        System.out.println("Starting a reserve auction");
        System.out.println("-----------------");

        ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Backpack", 25);

        reserveAuction.placeBid(new Bid("Josh", 10));
        reserveAuction.placeBid(new Bid("Fonz", 28));
        reserveAuction.placeBid(new Bid("Rick Astley", 25));

        System.out.println(reserveAuction.getHighBid().getBidder());


    }


}
