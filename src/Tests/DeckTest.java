package Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Game.Card;
import Game.Deck;
import Game.Suit;


public class DeckTest 
{
	private Deck dk;
	
	@Before 
	public void setUp() throws Exception
	{
		//dk = new Deck();
	}
	
	@Test
	public void UnsortedDeckTopCard() 
	{
		//Ace of Hearts
		dk = new Deck();
		Card cd = dk.nextCard();
		
		assertEquals(11,cd.GetCardValue());
	}
	@Test
	public void UnsortedDeckAfterOneSuit() 
	{
		// create a new unsorted deck, draw a complete suit, and get the next Ace (Ace of Diamonds) 
		dk = new Deck();
		Card cd = new Card(Suit.Diamonds,2); // Initiate the card to a random card
		for(int x = 0; x < 14; x++)
		{
			cd = dk.nextCard();
		}
		
		assertEquals(11, cd.GetCardValue());
	}
	@Test
	public void DealHalfDeck() 
	{
		dk = new Deck();
		
		for(int x = 0; x < 26; x++)
		{
			dk.nextCard();
		}
		
		assertEquals(26, dk.CardsOnDeck());
	}
	@Test
	public void DealUntilEmptyDeck() 
	{
		dk = new Deck();
		
		for(int x = 0; x < 52; x++)
		{
			dk.nextCard();
		}
		
		assertEquals(0, dk.CardsOnDeck());
	}
	@Test
	public void DealPastEmptyDeck() 
	{
		dk = new Deck();
		
		for(int x = 0; x < 55; x++)
		{
			dk.nextCard();
		}
		
		assertEquals(0, dk.CardsOnDeck());
	}
	@Test
	public void RefillEmptyDeck() 
	{
		dk = new Deck();
		
		for(int x = 0; x < 52; x++)
		{
			dk.nextCard();
		}
		dk.RefillDeck();
		
		assertEquals(52, dk.CardsOnDeck());
	}
	@Test
	public void RefillHalfEmptyDeck() 
	{
		dk = new Deck();
		
		for(int x = 0; x < 26; x++)
		{
			dk.nextCard();
		}
		dk.RefillDeck();
		
		assertEquals(52, dk.CardsOnDeck());
	}
	
	// Print
	@Test
	public void PrintUnsortedDeckTopCard() 
	{
		//Ace of Hearts
		dk = new Deck();
		Card cd = dk.nextCard();
		
		assertEquals("Ace of Clubs",cd.ToString());
	}
	@Test
	public void PrintUnsortedDeckAfterOneSuit() 
	{
		// create a new unsorted deck, draw a complete suit, and get the next Ace (Ace of Diamonds) 
		dk = new Deck();
		Card cd = new Card(Suit.Diamonds,2); // Initiate the card to a random card
		for(int x = 0; x < 14; x++)
		{
			cd = dk.nextCard();
		}

		assertEquals("Ace of Diamonds", cd.ToString());
	}

}

