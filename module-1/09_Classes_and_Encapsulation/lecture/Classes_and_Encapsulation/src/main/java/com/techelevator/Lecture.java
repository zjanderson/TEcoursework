package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    //in order to have an entry point into our program/project we will need a Main Method
    public static void main(String[] args) {
        System.out.println("Hello World!");


        Card aceOfSpades = new Card("Spades", "Ace", false);
        Card twoOfClubs = new Card("Clubs", "Two", true);

        aceOfSpades.color(); //will show "Black"
        aceOfSpades.getSuit(); //this will show "Spades"
        aceOfSpades.setSuit("Hearts");
        aceOfSpades.color(); //will now show "Red"

        Card aceOfDiamonds = new Card("Diamonds", "Ace");
        Card aceOfHearts = new Card("Hearts", "Ace");
        Card kingOfHearts = new Card("Hearts", "King");

        List<Card> pokerCard = new ArrayList<>();
        pokerCard.add(aceOfSpades);
        pokerCard.add(aceOfHearts);
        pokerCard.add(aceOfDiamonds);

        Deck pokerDeck = new Deck(pokerCard);

        pokerDeck.addCard(kingOfHearts);



    }



}
