/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {

    // In case We have Extra colors, this can be override
    public enum Suite {
        SPADE, CLUB, DIAMOND, HEART
    }

    // This can always be override to add new card name
    public enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    private final Suite suite;
    private final Value value;

    public Card(Suite suite, Value value) {
        this.suite = suite;
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

    public Suite getSuite() {
        return this.suite;
    }
    
    // To print easier. 
    public String toString(){
        return getValue() + " of " + getSuite();
    }
}