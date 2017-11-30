package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public Deck deck;

    public java.util.List<CardCollection> cols = new ArrayList<>(4);


    public Game() {
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++) {
            this.cols.add(i, new CardCollection());
        }
    }

    /*
    buildDeck creates a new deck object
     */
    public void buildDeck(){
        deck = new Deck();
    }

    /*
    shuffle uses the deck class to shuffle the deck
     */
    public void shuffle(){
        deck.shuffle();
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
