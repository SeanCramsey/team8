package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        g.buildDeck();
        assertEquals(52,g.deck.size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game();
        g1.buildDeck();
        g1.shuffle();
        Game g2 = new Game();
        g2.buildDeck();
        g2.shuffle();
        //TODO:Fix this
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        //assertFalse(Arrays.equals(g1.deck.cards.toArray(),g2.deck.cards.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).cards.size());
        assertEquals(1,g.cols.get(1).cards.size());
        assertEquals(1,g.cols.get(2).cards.size());
        assertEquals(1,g.cols.get(3).cards.size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        assertEquals("0Clubs",g.cols.get(0).cards.get(0).toString());
        assertEquals("3Clubs",g.cols.get(1).cards.get(0).toString());
        assertEquals("6Clubs",g.cols.get(2).cards.get(0).toString());
        assertEquals("9Clubs",g.cols.get(3).cards.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(3);
        assertEquals(0,g.cols.get(3).size());
    }



}
