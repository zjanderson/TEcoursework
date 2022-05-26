package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Deck {  //ask first, what is in a Deck?
    private List<Card> cards = new ArrayList<>();   //we are using a List to hold all of the Card objects

    public Deck(List<Card> c) {
        cards = c;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card dealOne() {
        if (cards.size() > 0) {
            return cards.remove(0);
        }

        return null;
    }
}
