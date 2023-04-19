package ca.sheridancollege.project;

import java.util.ArrayList;

public class Deck extends GroupOfCards {
    /*
     * Get a new 52 Shuffled card
     * @return a new shuffle deck of 52 cards
     */
    public Deck(){
        super(52);
        cards = new ArrayList<Card>();
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 13; j++)
                cards.add(new Card(Card.toSuite(i), Card.toValue(j)));
        }
        shuffle();
    }

    /*
     * For development purpose only, able to show the whole deck
     */
    public void showDeck(){
        int index = 0;
        for (Card card : cards){
            index++;
            System.out.println("Card no."+index+": "+card);
        }
    }

    public Card pullCard(){
        Card topOfDeck = cards.get(0);
        cards.remove(0);
        return topOfDeck;
    }
}
