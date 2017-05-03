package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Game.Player;
import Game.Suit;
import Game.Card;
import Game.Deck;


public class PlayerTest
{
	private Player p1;
	private Player dlr;
	
	@Before
	public void setUp() throws Exception
	{
		p1 = new Player("Player1", 1000);
		dlr = new Player("Dealer", 10000);
	}

	@Test
	public void StartWithoutCards() 
	{	
		assertEquals(0,p1.getCardCount());
	}
	// adding cards to player's holding cards
	@Test
	public void AddOneUnsortedCard() 
	{	
		Deck dk = new Deck();
		boolean added = p1.addCard(dk.nextCard());
		
		assertEquals(true, added);
	}
	@Test
	public void ValueAddOneUnsortedCard() 
	{	
		Deck dk = new Deck(); 	// first card of unsorted deck is the ace of clubs
		p1.addCard(dk.nextCard());
		
		assertEquals(11, p1.getHandSum());
	}
	@Test
	public void ValueOfTwoAces() 
	{	
		p1.addCard(new Card(Suit.Clubs,1));
		p1.addCard(new Card(Suit.Diamonds,1));
		
		assertEquals(12, p1.getHandSum());
	}
	@Test
	public void ValueOfSoft17() 
	{	
		p1.addCard(new Card(Suit.Clubs,1));
		p1.addCard(new Card(Suit.Diamonds,6));
		
		assertEquals(17, p1.getHandSum());
	}
	@Test
	public void ValueOfTwoAcesNine() 
	{	
		p1.addCard(new Card(Suit.Clubs,1));
		p1.addCard(new Card(Suit.Diamonds,1));
		p1.addCard(new Card(Suit.Hearts,9));
		
		assertEquals(21, p1.getHandSum());
	}
	@Test
	public void isBust() 
	{	
		p1.addCard(new Card(Suit.Clubs,1));
		p1.addCard(new Card(Suit.Diamonds,1));
		p1.addCard(new Card(Suit.Spades,10));
		p1.addCard(new Card(Suit.Hearts,12));
		
		assertEquals(true, p1.getBust());
	}
	@Test
	public void NotBust() 
	{	
		p1.addCard(new Card(Suit.Clubs,1));
		p1.addCard(new Card(Suit.Diamonds,8));		
		
		assertEquals(false, p1.getBust());
	}
	@Test
	public void AddingOver21Cards() 
	{	
		Deck dk = new Deck();
		boolean isValid = false;
		for (int num=1; num<=22; num++){ isValid=p1.addCard(dk.nextCard()); }
		
		assertEquals(false, isValid);
	}
	
	
	
	// adjusting your bet money balance
	@Test
	public void SubtractMoneyFromBet()
	{
		p1.adjustBetMoney(-100);
		
		assertEquals(900, p1.getBetMoneyBalance());
	}
	@Test
	public void BetOverBalance()
	{
		assertEquals(false, p1.adjustBetMoney(-1500));
	}
	@Test
	public void BetExactBalance()
	{
		assertEquals(true, p1.adjustBetMoney(-1000));
	}
	@Test
	public void AddMoneyToBet()
	{
		p1.adjustBetMoney(500);
		
		assertEquals(1500, p1.getBetMoneyBalance());
	}
	
	
	// After playing many hands and game restarts, user should be able to be reset
	@Test
	public void ResetPlayer_checkScore() 
	{	
		Deck dk = new Deck();
		for (int num=1; num<=10; num++){ p1.addCard(dk.nextCard()); }
		
		p1.Reset();
		
		assertEquals(0, p1.getHandSum());
	}
	@Test
	public void ResetPlayer_checkBetMoneyBalance() 
	{	
		Deck dk = new Deck();
		for (int num=1; num<=10; num++){ p1.addCard(dk.nextCard()); }
		
		p1.Reset();
		
		assertEquals(1000, p1.getBetMoneyBalance());
	}
	@Test
	public void EmptyHand()
	{
		p1.addCard(new Card(Suit.Diamonds, 2));
		p1.emptyHand();
		
		assertEquals(0, p1.getCardCount());
	}
	// Check Dealer Balance
	@Test
	public void DealerBetMoney() 
	{				
		assertEquals(10000, dlr.getBetMoneyBalance());
	}
	@Test
	// buy in
	public void PlayerBuyIn()
	{
		assertEquals(1000, p1.getBuyIn());
	}
	@Test
	public void PlayerNewlyDefinedBuyIn()
	{
		Player newPlayer = new Player("Player 1",5000);
		
		assertEquals(5000, newPlayer.getBuyIn());
	}
	@Test
	public void GetBustTrue()
	{
		p1.addCard(new Card(Suit.Diamonds, 10));
		p1.addCard(new Card(Suit.Hearts, 8));
		p1.addCard(new Card(Suit.Spades, 7));
		
		assertEquals(true, p1.getBust());
	}
	@Test
	public void GetBustFalse()
	{
		p1.addCard(new Card(Suit.Diamonds, 10));
		p1.addCard(new Card(Suit.Hearts, 8));
		
		assertEquals(false, p1.getBust());
	}
	
	// Check Dealer Balance
	@Test
	public void PrintPlayerName() 
	{				
		assertEquals("Player1", p1.ToString());
	}
	@Test
	public void PrintDealerName() 
	{				
		assertEquals("Dealer", dlr.ToString());
	}
}
