package com.cardgame.model;

import com.cardgame.model.Card.Rank;
import com.cardgame.model.Card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card drawingACard() {
        return deck.remove(0);
    }
}
