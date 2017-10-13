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

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
    }

	/*
	Deal Four does the equivalent of drawing four cards and then setting them on each holding column.
	*/
    public void dealFour() {
	Card tempCard = NULL; //creates variable as object type card
	for(i=0; i++; i<4) //loop to place a card in each column
	{
	tempCard = getTopCard(i); //draws card and saves in tempCard
	addCardToCol(i,tempCard); //places card in column
	}
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
    }

    private boolean columnHasCards(int columnNumber) {
        if(cols.get(columnNumber).length == 0)
	{
	return true;
	}
	else
	{
        return false;
	}
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        // save top card
        Card topCard = getTopCard(columnFrom);
        // remove top card
        removeCardFormCol(columnFrom);
        //Add card to new column
        addCardtoCol(columnTo,topCard);
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
