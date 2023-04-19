/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HaiTr
 */
public class BlackJackTest {

    public BlackJackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Running Tests! \n ======================================================");
    }

    @Before
    public void SetUp() {
        System.out.println("Starting Test! \n ======================================================");
    }

    @After
    public void tearDown() {
        System.out.println("Completed a Test! \n ======================================================");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished All Tests! \n ======================================================");
    }

    @Test
    public void useCase3Good() {
        System.out.println("This is a good test on use Case 3, where the player wins. The player is given blackjack and the dealer is given 7, the player should win in this case");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TWO));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();
        System.out.println("Player is given a blackjack and should win since it is one of the win conditions");
        assertEquals(true, player.hasBlackJack() && !dealer.hasBlackJack());

        player.hand.clear();
        dealer.hand.clear();

        player.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TWO));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();
        System.out.println("Player is given 20 and the dealer is given 7. The player should win since it is one of the win conditions");
        assertEquals(true, playerTotal > dealerTotal && playerTotal <= 21);
        player.hand.clear();
        dealer.hand.clear();
        player.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();
        System.out.println("The player gets a lower number than the dealer however, the dealer busts with a value over 21");
        assertEquals(true, dealerTotal > 21 && playerTotal <= 21);

    }

    @Test
    public void useCase3Bad() {
        System.out.println("This is a Boundary test on case 3");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.SIX));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Dealer is given a blackjack and the player should NOT win");
        assertEquals(false, player.hasBlackJack() && !dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TWO));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Dealer is given 20 and the player is given 7 and should NOT win");
        assertEquals(false, playerTotal > dealerTotal && playerTotal <= 21);

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();
        System.out.println("THe player should lose because even though he has a higher total he went over 21 which means dealer wins");
        assertEquals(false, dealerTotal > 21 && playerTotal <= 21);
    }

    @Test
    public void useCase3Boundary() {
        System.out.println("This is a Boundary test on use Case 3, where the player should win with their hand.");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.SIX));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();
        System.out.println("Player is given a blackjack and should win even though the dealer has 21");
        assertEquals(true, player.hasBlackJack() && !dealer.hasBlackJack());

        player.hand.clear();
        dealer.hand.clear();

        player.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();
        System.out.println("Player is given 20 and the dealer is given 19. The player should win since it is one of the win conditions");
        assertEquals(true, playerTotal > dealerTotal && playerTotal <= 21);
        player.hand.clear();
        dealer.hand.clear();
        player.addCardToHand(new Card(Card.Suite.HEART, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();
        System.out.println("The player gets a very low number and wins because the dealer goes over 21");
        assertEquals(true, dealerTotal > 21 && playerTotal <= 21);

    }

    @Test
    public void useCase4Good() {
        System.out.println("This is a Good test on case 4");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Dealer is given a blackjack and the player should NOT win");
        assertEquals(true, !player.hasBlackJack() && dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TWO));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Dealer is given 20 and the player is given 7 and should NOT win");
        assertEquals(true, dealerTotal > playerTotal && dealerTotal <= 21);

        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("THe player should lose because even though he has a higher total he went over 21 which means dealer wins");
        assertEquals(true, playerTotal > 21 && dealerTotal <= 21);
    }

    @Test
    public void useCase4Bad() {
        System.out.println("This is a bad test on case 4");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Player is given a blackjack and the Dealer should NOT win");
        assertEquals(false, !player.hasBlackJack() && dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        player.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TWO));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Player is given 20 and the dealer is given 7 and should NOT win");
        assertEquals(false, dealerTotal > playerTotal && dealerTotal <= 21);

        player.hand.clear();
        dealer.hand.clear();

        player.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("THe player should lose because even though he has a higher total he went over 21 which means dealer wins");
        assertEquals(false, playerTotal > 21 && dealerTotal <= 21);
    }

    @Test
    public void useCase4Boundary() {
        System.out.println("This is a Boundary test on case 4");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.KING));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.KING));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Dealer is given a blackjack and the player should NOT win");
        assertEquals(true, !player.hasBlackJack() && dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.KING));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Dealer is given 20 and the player is given 19 and should NOT win");
        assertEquals(true, dealerTotal > playerTotal && dealerTotal <= 21);

        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TWO));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("THe player should lose because even though he has a higher total he went over 21 which means dealer wins");
        assertEquals(true, playerTotal > 21 && dealerTotal <= 21);
    }

    @Test
    public void useCase5Good() {
        System.out.println("This is a Good test on case 5");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Dealer and Player is given a blackjack. THey should tie.");
        assertEquals(true, player.hasBlackJack() && dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.QUEEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.QUEEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Dealer and player is given the same amount");
        assertEquals(true, dealerTotal == playerTotal);

        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Both the player and the dealer bust, they both tie.");
        assertEquals(true, playerTotal > 21 && dealerTotal > 21);
    }

    @Test
    public void useCase5Bad() {
        System.out.println("This is a Bad test on case 5");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.FIVE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Dealer is given a blackjack. THey should not tie.");
        assertEquals(false, player.hasBlackJack() && dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.QUEEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.EIGHT));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Dealer and player is given different amounts, they should not tie.");
        assertEquals(false, dealerTotal == playerTotal);

        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("the player does not busy but the dealer does bust, they do not tie.");
        assertEquals(false, playerTotal > 21 && dealerTotal > 21);
    }

    @Test
    public void useCase5Boundary() {
        System.out.println("This is a Boundary test on case 5");
        BlackJack instance = new BlackJack();
        MainPlayer player = new MainPlayer("Test");
        Dealer dealer = new Dealer();
        instance.addPlayer(dealer);
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.QUEEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.KING));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.ACE));

        int playerTotal = player.handSum();
        int dealerTotal = dealer.handSum();

        System.out.println("Dealer and Player is given a blackjack but with different cards. THey should tie.");
        assertEquals(true, player.hasBlackJack() && dealer.hasBlackJack());
        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.QUEEN));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.KING));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Dealer and player is given the same amount but with different cards");
        assertEquals(true, dealerTotal == playerTotal);

        player.hand.clear();
        dealer.hand.clear();

        dealer.addCardToHand(new Card(Card.Suite.HEART, Card.Value.FIVE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.NINE));
        dealer.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.TEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.SIX));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.SEVEN));
        player.addCardToHand(new Card(Card.Suite.CLUB, Card.Value.KING));
        playerTotal = player.handSum();
        dealerTotal = dealer.handSum();

        System.out.println("Despite having very different cards, both will still tie");
        assertEquals(true, playerTotal > 21 && dealerTotal > 21);
    }
}
