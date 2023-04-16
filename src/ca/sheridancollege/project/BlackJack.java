package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack extends Game {
    private double starting;
    private Deck deck;

    /**
     * Constructor with game setup
     * set starting balance value
     * set a new Shuffled Deck
     * add a dealer
     */
    public BlackJack(){
        super("Black Jack");
        starting = 100;
        deck = new Deck();
        ArrayList<Player> player = new ArrayList<Player>();
        player.add(new Dealer());
        setPlayers(player);
    }

    public void intro(){
        System.out.println("Welcome to "+getName());
    }

    /**
     * This method prompt to take player's name
     * @return the name
     */
    public String getPlayerName(){
        System.out.println("Please enter your name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (name.isEmpty()){
            name = "Anonymous";
        }
        return name;
    }

    /**
     * This method ask the user to enter a name and create a new playable player with that name.
     * Including a starting balance.
     * @return player with a starting balance
     */
    public MainPlayer createPlayer(){
        String name = getPlayerName();
        MainPlayer player = new MainPlayer(name);
        player.earn(starting);
        return player;
    }

    /**
     * Overwrite the old list of player with new list of player
     * @param player to add
     * set the game's list of player to a new list with the old list plus the new player added
     */
    public void addPlayer(Player player){
        ArrayList<Player> players = getPlayers();
        players.add(player);
        setPlayers(players);
    }

    public void showPlayerInfo(Player player){
        System.out.println(player);
    }

    public void showAllPlayerInfo(){
        ArrayList<Player> players = getPlayers();
        for (Player player: players){
            System.out.println(player);
        }
    }

    public Player getDealer(){
        ArrayList<Player> players = getPlayers();
        return players.get(0);
    }

    public Player getMainPlayer(){
        ArrayList<Player> players = getPlayers();
        return players.get(1);
    }

    /**
     * Game flow. Edit this.
     */
    @Override
    public void play() {
        intro();
        addPlayer(createPlayer());    
        showAllPlayerInfo();
        enterToContinue();

        Player player = getMainPlayer();
        player.play(deck);
        Player dealer = getDealer();
        dealer.play(deck);
        showAllPlayerInfo();
    }

    @Override
    public void declareWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'declareWinner'");
    }

    public void enterToContinue(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press anything to continue...");
        input.nextLine();
    }
    
}
