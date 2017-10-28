package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of for future assignments.
 */

public class Card implements Serializable {
    public final int value;
    public final Suit suit;
    //public final String img;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;
        //this.img = ("https://raw.githubusercontent.com/hayeah/playing-cards-assets/master/png/" + value + "_of_" + suit + ".png").toLowerCase();

    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return this.value + this.suit.toString();
    }
}
