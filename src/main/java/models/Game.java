package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
abstract public class Game {
    public Deck deck;

    public java.util.List<CardCollection> cols = new ArrayList<>(4);


    /*
    buildDeck creates a new deck object
     */
    abstract public void buildDeck();

    /*
    shuffle uses the deck class to shuffle the deck
     */
    public void shuffle(){
        deck.shuffle();
    }

    /**
     * Deal Four does the equivalent of drawing four cards and then setting them on each holding column.
     */
    abstract public void dealFour();

    /**
     * This removes cards based on the implementation of game
     */
    abstract public void remove(int columnNumber);


    //If column has cards, return true, otherwise false
    protected boolean columnHasCards(int columnNumber) {
        // if empty return true, else false
        if(this.cols.get(columnNumber).size()>0){
            return true;
        }
        return false;
    }

    protected Card getTopCard(int columnNumber) {
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

    protected void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
    
}
