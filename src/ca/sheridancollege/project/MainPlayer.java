package ca.sheridancollege.project;

import java.util.Scanner;

public class MainPlayer extends Player{
    private double balance; // the balance of this player

    public MainPlayer(String name){
        super(name);
    }

    public void play(Deck deck){
        // Player will initially have 2 cards
        addCardToHand(deck.pullCard());
        addCardToHand(deck.pullCard());
        System.out.println(toString());
        Boolean hold = hasBlackJack();
        // Hold right away if hasBlackJack
        if (hold) {
            System.out.println("Player has BlackJack!");
        }
        while (!hold){
            hold = pullTillHold(deck);
        }
    }

    /**
     * Game loop continues until Player decide to hold
     * @param deck - Sync the deck
     * @return true once Hand is full or Player decide to hold
     */
    public Boolean pullTillHold(Deck deck){
        System.out.println("Pull the next card?\nPress enter to pull, press Q to hold");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if (!choice.equals("q") && !choice.equals("Q")){
            addCardToHand(deck.pullCard());
            System.out.println(toString());
            return handIsFull();
        } 
        return true;
    }



    public double getBalance(){
        return balance;
    }
    
    public void earn(double amount){
        balance += amount;
    }
    
    public void bet(double amount){
        balance -= amount;
    }

    @Override
    public String toString(){
        return "========"+getName()+"========\n"+showHand()+"\nBalance: "+getBalance()+"\n========"+getName()+"========\n";
    }
}
