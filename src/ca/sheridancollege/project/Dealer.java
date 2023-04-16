package ca.sheridancollege.project;

public class Dealer extends Player {
    public Dealer(){
        super("Dealer");
    }

    public void play(Deck deck) {
        // Dealer will initially have 2 cards
        addCardToHand(deck.pullCard());
        addCardToHand(deck.pullCard());
        Boolean hold = hasBlackJack();
        if (hold){
            System.out.println("Dealer has Black Jack!");
        }
    }
}
