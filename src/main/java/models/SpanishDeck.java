package models;

import java.util.ArrayList;

public class SpanishDeck extends Deck {
    public SpanishDeck(){
        cards = new ArrayList<Card>();
        for(int i = 2; i < 15; i++){
            cards.add(new Card(i, Suit.Clubs));
            cards.add(new Card(i, Suit.Hearts));
            cards.add(new Card(i, Suit.Diamonds));
            cards.add(new Card(i, Suit.Spades));
        }
        //Remove 10th card and add the jokers
        cards.remove(new Card(10, Suit.Clubs));
        cards.remove(new Card(10, Suit.Hearts));
        cards.remove(new Card(10, Suit.Diamonds));
        cards.remove(new Card(10, Suit.Spades));
        cards.add(new Card(15,Suit.Joker));
        cards.add(new Card(15,Suit.Joker));
    }
}
