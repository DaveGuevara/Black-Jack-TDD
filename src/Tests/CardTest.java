package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Game.Card;
import Game.Suit;

public class CardTest {

	private Card cd;
	
	@Before 
	public void setUp() throws Exception
	{
		//cd = new Card();
	}
		
	@Test
	public void CreateTwoSpades() 
	{
		cd = new Card(Suit.Spades, 2);
		assertEquals(2,cd.GetCardValue());
		
	}
	@Test
	public void CreateJackDiamonds() 
	{
		cd = new Card(Suit.Diamonds,11);
		assertEquals(10,cd.GetCardValue());
		
	}
	@Test
	public void CreateQueenHearts() 
	{
		cd = new Card(Suit.Hearts,12);
		assertEquals(10,cd.GetCardValue());
		
	}
	@Test
	public void CreateAceHearts() 
	{
		cd = new Card(Suit.Hearts,1);
		assertEquals(11,cd.GetCardValue());
		
	}
}
