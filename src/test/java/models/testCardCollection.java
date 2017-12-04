package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCardCollection{

    @Test
    public void testAdd(){
        CardCollection col = new CardCollection(0);
        Card c = new Card(5,Suit.Clubs, DeckType.Standard);
        col.add(c);
        assertEquals(col.size(), 1);
    }

    @Test
    public void testRemove(){
        CardCollection col = new CardCollection(1);
        Card c = new Card(5,Suit.Clubs, DeckType.Standard);
        col.add(c);
        assertEquals(col.size(), 1);
        col.remove(0);
        assertEquals(col.size(), 0);
    }


}