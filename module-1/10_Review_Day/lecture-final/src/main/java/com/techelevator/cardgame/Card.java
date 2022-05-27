package com.techelevator.cardgame;

public class Card {
    /*
        Fields, Properties, Member Variables, Instance Variables
     */
    private String suit;
    private String rank;
    private boolean isFaceUp = true;

    /*
        Constructors
     */
    public Card(String suit, String rank) {
        this(suit, rank, true);
    }

    public Card(String s, String r, boolean faceUp) {
        suit = s;
        rank = r;
        isFaceUp = faceUp;
    }

    /*
        Getters and Setters
     */
    public String getSuit() {
        return suit;
    }

    public void setSuit(String s) {
        suit = s;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    // Derived property
    public String getColor() {
        if (suit.equals("Clubs") || suit.equals("Spades")) {
            return "Black";
        }

        return "Red";
    }

    // derived property for color, symbol, how many of that symbol appear

    /*
        Methods
     */
    public boolean flip() {
        isFaceUp = !isFaceUp;

        return isFaceUp;
    }

    public String displayCard() {
        if (isFaceUp) {
            return rank + " of " + suit + " is color " + getColor();
        } else {
            return "##";
        }
    }
}
