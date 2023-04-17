package ca.sheridancollege.project;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public void play(Deck deck) {
        hand.clear();
        // Dealer will initially have 2 cards
        addCardToHand(deck.pullCard());
        addCardToHand(deck.pullCard());
        Boolean hold = hasBlackJack();
        int handTotal = handSum();
        if (hold) {
            System.out.println("Dealer has Black Jack!");
        }
        if (handTotal <= 15) {
            addCardToHand(deck.pullCard());
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "========" + getName() + "========\n" + showHand() + "\n========" + getName() + "========\n";
    }
}
