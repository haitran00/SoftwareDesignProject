/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancyea
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {

    private String name; //the unique name for this player
    protected Hand hand; // The maximum card the player can have
    
    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setHandSize(int size){
        hand.setSize(size);
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play(Deck deck);

    /**
     * This method check if the player has BlackJack
     * @return true if has
     * @return false otherwise
     */
    public Boolean hasBlackJack(){
        if (hand.getSize() == 2){
            Card firstCard = hand.cards.get(0);
            Card secondCard = hand.cards.get(1);
            return (firstCard.getValue().equals(Card.Value.ACE) && secondCard.toCountValue() == 10) || 
                    (secondCard.getValue().equals(Card.Value.ACE) && firstCard.toCountValue() == 10);
        }
        return false;
    }

    /**
     * @return the sum of all values in the player's hand
     */
    public int handSum(){
        int sum = 0;
        if (hand.getSize() > 0){
            for (Card card: hand.cards){
                sum += card.toCountValue();
            }
        }
        return sum;
    }

    /**
     * A method to add a card to the player hand
     * @param card to add to hand
     * @return true if player can add more card to hand
     * @return false otherwise
     */
    public Boolean addCardToHand(Card card){
        if (!handIsFull()){
            hand.cards.add(card);
            return true;
        }
        else {
            System.out.println("Hand is full!");
            return false;
        }
    }

    /**
     * Check if the hand is full and unable to get more cards
     * @return true if full.
     */
    public Boolean handIsFull(){
        return hand.cards.size() >= hand.getSize();
    }

    public String showHand(){
        return "Card in "+getName()+" hand:\n" + hand.showHand();
    }

    public String toString(){
        return "========"+getName()+"========\n"+showHand()+"\n========"+getName()+"========\n";
    }
}
