package models;

import org.junit.Test;

import static org.junit.Assert.*;

//This tests out the suits.java
public class testSpanish{

    //this is an example of how the test should be setup as a function:
   
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs,DeckType.Spanish);
        assertEquals(Suit.Clubs,c.getSuit());
        Card h = new Card(5,Suit.Swords, DeckType.Spanish);
        assertEquals(Suit.Swords,h.getSuit());
         Card s = new Card(5,Suit.Coins, DeckType.Spanish);
        assertEquals(Suit.Coins,s.getSuit());
         Card d = new Card(5,Suit.Cups, DeckType.Spanish);
        assertEquals(Suit.Cups,d.getSuit());
    }
    
}
    
