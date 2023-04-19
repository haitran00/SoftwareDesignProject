package ca.sheridancollege.project;

import java.util.Scanner;

public class MainPlayer extends Player {

    private double balance = 1000; // the balance of this player
    private double betAmount;

    public MainPlayer(String name) {
        super(name);
    }

    public void play(Deck deck) {
        hand.clear();
        // Player will initially have 2 cards
        addCardToHand(deck.pullCard());
        addCardToHand(deck.pullCard());
        System.out.println(toString());
        int handTotal = handSum();
        Boolean hold = hasBlackJack();
        System.out.println("Your current hand total is: " + handTotal);
        // Hold right away if hasBlackJack
        if (hold) {
            System.out.println("Player has BlackJack!");
            return;
        }
        while (!hold || handTotal > 21) {
            hold = pullTillHold(deck);
            handTotal = handSum();
            System.out.println("Your current hand total is: " + handTotal);
            if (handTotal > 21) {
                System.out.println("You lost!\n" + "Your hand total is: " + handTotal);
                return;
            }
        }
    }

    /**
     * Game loop continues until Player decide to hold
     *
     * @param deck - Sync the deck
     * @return true once Hand is full or Player decide to hold
     */
    public Boolean pullTillHold(Deck deck) {
        System.out.println("Pull the next card?\nPress enter to pull, press Q to hold");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        //This will initalize the sum of the players hand

        if (!choice.equals("q") && !choice.equals("Q")) {
            addCardToHand(deck.pullCard());
            /*If the player decides to hit and detects that the hand is over 21
            It will stop the player from hitting again
             */
            System.out.println(toString());
            return handIsFull();
        }

        return true;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void earn() {
        balance += betAmount;
        System.out.println("Your total is now: " + balance);
    }

    @Override
    public void tie() {
        System.out.println("Your total is now: " + balance);
    }

    @Override
    public void bet() {
        Scanner input = new Scanner(System.in);
        if (balance == 0){
            System.out.println("Sorry you have no more funds! The game will now end!");
            System.exit(0);
        }
        System.out.println("How much would you like to bet?");
        double amount = input.nextDouble();
        while (amount > balance) {
            System.out.println("I'm sorry, the bet you entered exceeds your balance amount. Your balance is currently: " + balance);
            System.out.println("How much would you like to bet?");
            amount = input.nextDouble();
        }
        setBetAmount(amount);
    }

    public void setBalance(double amount){
        balance = amount;
    }
    /* 
     * Only set Bet Amount if the bet amount is less than or equal the balance
    */
    public void setBetAmount(double amount){
        if (amount <= balance){
            betAmount = amount;
        }
    }
    
    public void lose(){
        balance-= betAmount;
    }

    @Override
    public String toString() {
        return "========" + getName() + "========\n" + showHand() + "\nBalance: " + getBalance() + "\n========" + getName() + "========\n";
    }
}