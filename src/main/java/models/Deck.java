package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck extends CardCollection{

    public Deck(){
        cards = new ArrayList<Card>();
        for(int i = 2; i < 15; i++){
            cards.add(new Card(i, Suit.Clubs));
            cards.add(new Card(i, Suit.Hearts));
            cards.add(new Card(i, Suit.Diamonds));
            cards.add(new Card(i, Suit.Spades));
        }
    }

    /*
    shuffles the deck
    */
    public void shuffle(){
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }

}