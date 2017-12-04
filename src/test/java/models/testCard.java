package models;

import org.junit.Test;

import static org.junit.Assert.*;

//This tests out the suits.java
public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs, DeckType.Standard);
        assertEquals(Suit.Clubs,c.getSuit());
         Card h = new Card(5,Suit.Hearts, DeckType.Standard);
        assertEquals(Suit.Hearts,h.getSuit());
         Card s = new Card(5,Suit.Spades, DeckType.Standard);
        assertEquals(Suit.Spades,s.getSuit());
         Card d = new Card(5,Suit.Diamonds, DeckType.Standard);
        assertEquals(Suit.Diamonds,d.getSuit());
    }
//test tostring function
    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs, DeckType.Standard);
        assertEquals("5Clubs",c.toString());
        Card h = new Card(7,Suit.Hearts, DeckType.Standard);
        assertEquals("7Hearts",h.toString());
        Card s = new Card(3,Suit.Spades, DeckType.Standard);
        assertEquals("3Spades",s.toString());
        Card d = new Card(4,Suit.Diamonds, DeckType.Standard);
        assertEquals("4Diamonds",d.toString());
    }
//test Move function and remove function.
    @Test
    public void testMoveCard(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(3);
        assertEquals(0,g.cols.get(3).size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).size());
        assertEquals(0,g.cols.get(0).size());
    }
    //test the cardCollection functions
   // @Test
    //public void testCardCollection()
    //{
     //   Game g = new Game();
        
        
    //}
        

}
