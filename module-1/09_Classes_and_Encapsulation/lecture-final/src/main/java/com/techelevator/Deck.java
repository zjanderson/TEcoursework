package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {

    }

    public Deck(List<Card> c) {
        cards = c;
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public Card dealOne() {
        if (cards.size() > 0) {
            return cards.remove(0);
        }

        return null;
    }
}
