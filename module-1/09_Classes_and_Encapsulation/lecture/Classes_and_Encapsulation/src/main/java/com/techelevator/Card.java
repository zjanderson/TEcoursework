package com.techelevator;

public class Card {
    /// These are FIELDS, aka PROPERTIES, aka MEMBER VARIABLES, aka INSTANCE VARIABLES
    private String suit;
    private String rank;
    private boolean isFaceUp;
    //derived property for color, symbol, how many of that symbol on the card
    //once we have our fields (above), we need a constructor with no return type to start working with our data
    //when writing a constructor, think about what data you need to have @ minimum to have useful object

    //// These are CONSTRUCTORS

    public Card(String suit, String rank) {
        this.suit = suit;  //using this.<any field> will reference your original field in the class, NOT the one in the local scope
        this.rank = rank;
        isFaceUp = true;
    }

    public Card(String suit, String rank, boolean isFaceUp){
        this.suit = suit;  //using this.<any field> will reference your original field in the class, NOT the one in the local scope
        this.rank = rank;
        this.isFaceUp = isFaceUp; //this allows the user to specify if the card is face up or face down
    }

    //// These are GETTERS & SETTERS, they control access to my FIELDS

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String color() {  //derived field, so it doesn't have getColor
        if (suit.equals("Clubs") || (suit.equals("Spades"))) {
            return "Black";
        }
            return "Red";
    }

    public boolean flip() {
        isFaceUp = !isFaceUp;

        return isFaceUp;
    }

    public String displayCard() {
        if (isFaceUp) {
            return rank + " of " + suit;
        } else {
            return "##";
        }
    }


}
