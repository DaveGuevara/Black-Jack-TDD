package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Game.Game;
import Game.Player;
import Game.Selector;
import Game.Suit;
import Game.Card;

public class GameTest 
{
	private Game gm;

	@Before
	public void setUp() throws Exception
	{
		gm = new Game();
	}
	
	
	@Test
	public void GameStarts1() throws Exception
	{	
		//empty constructor
		assertEquals(gm.GetCardCount(Selector.Player),gm.GetCardCount(Selector.Dealer));
	}
	@Test
	public void GameStarts2() throws Exception
	{	
		// constructor takes player parameters
		Player pr1 = new Player("Player1",1000);
		Player dlr1 = new Player("Dealer", 10000);
		Game gm2 = new Game(pr1,dlr1);
		gm2.DealHand();
		gm2.DealHand();
		
		assertEquals(gm2.GetCardCount(Selector.Player),gm2.GetCardCount(Selector.Dealer));
	}
	@Test
	public void GameStarts3() throws Exception
	{	
		// constructor takes player and dealer buyins
		Game gm3 = new Game(1000,10000);
		
		assertEquals(gm3.GetCardCount(Selector.Player),gm3.GetCardCount(Selector.Dealer));
	}
	
	
	@Test
	public void Restart() throws Exception
	{
		gm.DealHand();
		gm.DealHand();
		gm.DealHand();
		gm.Restart();
		assertEquals(0,gm.GetCardCount(Selector.Dealer));
	}
	@Test
	public void GetNewDeck() throws Exception
	{
		gm.ShuffleCurrentDeck();
		gm.GetNewDeck();		// creates a new unshuffled deck
		gm.DealHand(Selector.Player);  // first hand should be ace of hearts
		
		assertEquals(new Card(Suit.Hearts,1).GetCardValue(),gm.GetHandSum(Selector.Player));
	}
	@Test
	public void ClearHoldingCards() throws Exception
	{
		gm.DealHand();
		gm.DealHand();
		gm.ClearHoldingCards();
		assertEquals(0,gm.GetCardCount(Selector.Dealer));
	}
	@Test
	public void DealHand() throws Exception
	{
		gm.DealHand();
		assertEquals(1,gm.GetCardCount(Selector.Dealer));
	}
	@Test
	public void DealIndividualHand() throws Exception
	{
		gm.DealHand(Selector.Player);
		assertNotSame(gm.GetCardCount(Selector.Player), gm.GetCardCount(Selector.Dealer));
	}
//	@Test
//	public void DealSameHand() throws Exception
//	{
//		gm.GetNewDeck();
//		gm.DealHand(Selector.Player);
//		gm.GetNewDeck();
//		gm.DealHand(Selector.Dealer);
//		
//		assertArrayEquals(gm.GetHoldingCards(Selector.Player), gm.GetHoldingCards(Selector.Dealer));
//	}
//
	@Test
	public void AddBetPot() throws Exception
	{
		//both players bet in 400 dollars, so player 1 initial balance of 1000 - 400 = 600
		gm.AddBetPot(400);  
		assertEquals(600, gm.GetBetBalance(Selector.Player));
	}
	@Test
	public void DecideWinner() throws Exception
	{
		gm.GetNewDeck();
		gm.DealHand(Selector.Player); //ace
		gm.DealHand(Selector.Player); //2
		gm.DealHand(Selector.Player); //3
		gm.DealHand(Selector.Player); //4
		// player total = 20
		gm.GetNewDeck();
		gm.DealHand(Selector.Dealer); //ace
		gm.DealHand(Selector.Dealer); //2
		gm.DealHand(Selector.Dealer); //3
		// dealer total = 16
		
		assertEquals(Selector.Player, gm.DecideWinner());
	}

}
