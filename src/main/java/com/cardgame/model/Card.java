package com.cardgame.model;

public class Card implements Comparable<Card>{

    private Suit suit;
    private Rank rank;

    public Card(Suit suit,Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank.compareTo(o.rank);
    }

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    public enum Rank{
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }
}
