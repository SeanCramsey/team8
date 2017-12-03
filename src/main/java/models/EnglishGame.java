package models;

import java.util.ArrayList;

public class EnglishGame extends Game {

    public EnglishGame() {
        // initialize a new game such that each column can store cards
        for (int i = 0; i < 4; i++) {
            this.cols.add(i, new CardCollection());
        }
    }

    /*
    buildDeck creates a new deck object
     */
    public void buildDeck() {
        deck = new Deck();
    }

    /*
    Deal Four does the equivalent of drawing four cards and then setting them on each holding column.
    */
    public void dealFour() {
        Card tempCard; //creates variable as object type card
        //loop to place a card in each column
        for (int i = 0; i < 4; i++) {
            //Draw card from deck
            tempCard = deck.get(0);
            deck.remove(0);
            addCardToCol(i, tempCard); //places card in column
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
}
