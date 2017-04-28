package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Game.Player;
import Game.Deck;
import Game.Card;
import Game.Suit;

public class PlayerTest
{
	private Player p1;
	
	@Before
	public void setUp() throws Exception
	{
		p1 = new Player("Player1", 1000);
	}

	@Test
	public void StartWithoutCards() 
	{	
		assertEquals(0,p1.getCardCount());
	}
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
	

}
