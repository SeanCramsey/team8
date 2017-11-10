package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
    // initialize a new game such that each column can store cards
      for ( int i = 0; i < 4; i++){
        this.cols.add(i, new ArrayList<Card>());
      }
    }

    //This builds the deck by adding cards
    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    //Shuffles the deck for gameplay
    public void shuffle() {
        //Seed random number generator
        long seed = System.nanoTime();
        // shuffles the deck so that it is random
        Collections.shuffle(deck, new Random(seed));
    }

	/*
	Deal Four does the equivalent of drawing four cards and then setting them on each holding column.
	*/
    public void dealFour() {
	Card tempCard; //creates variable as object type card
    //loop to place a card in each column
	for(int i=0; i<4; i++) {
        //Draw card from deck
        tempCard = deck.get(0);
        //remove from deck
        deck.remove(0);
        addCardToCol(i,tempCard); //places card in column
        }
    }

    //This removes the card based on the rules of aces high
    public void remove(int columnNumber) {
        Card c = getTopCard(columnNumber);
        boolean removeCard = false;
        //Go thru columns to see if there is a larger card of same suit
        for (int i = 0; i < 4; i++) {
            if (i != columnNumber) {
                if (columnHasCards(i)) {
                    Card compare = getTopCard(i);
                    if (compare.getSuit() == c.getSuit()) {
                        if (compare.getValue() > c.getValue()) {
                            removeCard = true;
                        }
                    }
                }
            }
        }
        //If there is, remove the card
        if (removeCard) {
            this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
        }
        //Otherwise TODO:Add error message if not possible to remove
    }

    //If column has cards, return true, otherwise false
    private boolean columnHasCards(int columnNumber) {
        // if empty return true, else false
        if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    //Moves a card from one column to another
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        // save top card
        Card topCard = getTopCard(columnFrom);
        // remove top card
        removeCardFromCol(columnFrom);
        //Add card to new column
        addCardToCol(columnTo , topCard);
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
