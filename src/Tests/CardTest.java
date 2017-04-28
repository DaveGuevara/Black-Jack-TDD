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
		
	// Points
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
	
	
	// Print
	@Test
	public void PrintTwoSpades() 
	{
		cd = new Card(Suit.Spades, 2);
		assertEquals("2 of Spades", cd.ToString());
	}
	@Test
	public void PrintJackDiamonds() 
	{
		cd = new Card(Suit.Diamonds,11);
		assertEquals("Jack of Diamonds", cd.ToString());
	}
	@Test
	public void PrintQueenHearts() 
	{
		cd = new Card(Suit.Hearts,12);
		assertEquals("Queen of Hearts", cd.ToString());
	}
	@Test
	public void PrintAceHearts() 
	{
		cd = new Card(Suit.Hearts, 1);
		assertEquals("Ace of Hearts",cd.ToString());
		
	}
}
