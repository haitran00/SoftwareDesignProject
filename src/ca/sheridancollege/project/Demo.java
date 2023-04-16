package ca.sheridancollege.project;

public class Demo {
    public static void main(String[] args) {
        // deckTest();
        // pullTest();
        // playerTest();
        gameTest();
    }
    public static void deckTest(){
        System.out.println("Demo Show Deck");
        Deck deck = new Deck();
        deck.showDeck();
    }
    
    public static void pullTest(){
        Deck deck = new Deck();
        System.out.println("Before the pull: ");
        deck.showDeck();

        System.out.println("\nPulling a card: "+deck.pullCard());
        System.out.println("\nAfter pull: \n");
        deck.showDeck();
    }

    public static void playerTest(){
        Deck deck = new Deck();
        MainPlayer p1 = new MainPlayer("Demo Player");
        Dealer dealer = new Dealer();
        System.out.println(" ======"+p1.getName()+"'s turn ======");
        p1.play(deck);
        System.out.println(p1);
        System.out.println(" ======"+dealer.getName()+"'s turn ======");
        dealer.play(deck);
    }

    public static void gameTest(){
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }

}
