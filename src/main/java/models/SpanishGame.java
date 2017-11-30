package models;

public class SpanishGame extends Game {
    public SpanishGame(){
        for( int i = 0; i < 4; i++){
            this.cols.add(i, new CardCollection());
        }
    }
    /*
     * Builds a spanish deck, overloads normal build deck
     */
    public void buildDeck(){
        deck = new SpanishDeck();
    }
    /*
     * Removes a card if it follows the rules, overloads normal remove.
     *
     * @param   int columnNumber
     */
    public void remove(int columnNumber) {
        Card c = getTopCard(columnNumber);
        boolean removeCard = false;
        boolean joker = false;
        int jokerIdx = -1;
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
                    //If joker is found, remove Joker and set remove card to true
                    if (compare.getSuit() == Suit.Joker){
                        if (compare.getValue() > c.getValue()) {
                            joker = true;
                            jokerIdx = i;
                        }
                    }
                }
            }
        }
        //If there is, remove the card
        if (removeCard) {
            this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
            return;
        }
        //If there isn't a larger card but there is a joker, use joker rule
        if (joker){
            this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
            this.cols.get(jokerIdx).remove(this.cols.get(jokerIdx).size() - 1);
            return;
        }
    }
}
