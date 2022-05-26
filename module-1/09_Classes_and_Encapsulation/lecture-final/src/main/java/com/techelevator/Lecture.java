package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String suit = "Spades";
        Card aceOfSpades = new Card(suit, "Ace", false);
        Card twoOfClubs = new Card("Clubs", "Two", true);

        aceOfSpades.color();
        aceOfSpades.getSuit();
        aceOfSpades.setSuit("Hearts");
        aceOfSpades.color();

        Card aceOfDiamonds = new Card("Diamonds", "Ace");
        Card aceOfHearts = new Card("Hearts", "Ace");
        Card kingOfHearts = new Card("Hearts", "king");

        Deck emptyDeck = new Deck();

        List<Card> pokerCards = new ArrayList<>();
        pokerCards.add(aceOfSpades);
        pokerCards.add(aceOfHearts);
        pokerCards.add(aceOfDiamonds);

        Deck pokerDeck = new Deck(pokerCards);

        pokerDeck.addCard(kingOfHearts);
    }
}
