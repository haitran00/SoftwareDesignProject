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

    public static Suite toSuite(int index){
        switch(index){
            default:
                return Suite.CLUB;
            case 1:
                return Suite.DIAMOND;
            case 2:
                return Suite.HEART;
            case 3:
                return Suite.SPADE;
        }
    }

    public static Value toValue(int index){
        switch(index){
            default:
                return Value.ACE;
            case 2:
                return Value.TWO;
            case 3:
                return Value.THREE;
            case 4:
                return Value.FOUR;
            case 5:
                return Value.FIVE;
            case 6:
                return Value.SIX;
            case 7:
                return Value.SEVEN;
            case 8:
                return Value.EIGHT;
            case 9:
                return Value.NINE;
            case 10:
                return Value.TEN;
            case 11:
                return Value.JACK;
            case 12:
                return Value.QUEEN;
            case 13:
                return Value.THREE;
        }
    }

    public String toSymbol(){
        switch (getValue()){
            default:
                return "A";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case TEN: 
                return "10";
            case JACK:
                return "J";
            case QUEEN:
                return "Q";
            case KING:
                return "K";
        }
    }

    public int toCountValue(){
        switch (getValue()){
            case ACE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN: 
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                return -1;
        }
    }
}