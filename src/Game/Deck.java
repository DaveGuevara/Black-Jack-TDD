package Game;

import java.util.Random;

/**  
 * Creation Deck
 * Created: April 20, 2017 
 * Author: Khaled & David
 * 
 */
public class Deck {
	
	//Array of cards  
	private Card[] card;
	private int cardNumber;
	
	
	//Constructor with not being shuffled and one deck(BEFORE START)
	public Deck()
	{
		//call other Constructor defining one deck with out shuffling
		this(false);
	}
	
	//Constructor to offer the shuffle option
	public Deck(boolean shuffle) {
		//52 cards
		this.cardNumber = 52;
		//Total slots of 52 ARRAY
		this.card = new Card[this.cardNumber];
		
		//location of the card
		int cardLocation= 0;
		
		// each suit
		for(int suit = 0; suit < 4; suit++)
		{
			//each number in the deck
			for(int num = 1; num <=13; num++)
			{
				// add a new card to the deck 
				this.card[cardLocation] = new Card(Suit.values()[suit],num);
				cardLocation++;
			}
		}
		
		//Shuffling done
		if(shuffle == true)
		{
			this.shuffle();
		}
	}
	
	//Shuffle
	public void shuffle()
	{
		Random random = new Random(); // generate random number
		Card temp; // Temp Card
		int set;
		
		for (int i = 0; i < this.cardNumber; i++)
		{	
			// get a random random to swap card i with
			set = random.nextInt(this.cardNumber);
			
			// do swap do it like this so we do not lose the value 
			// so "i" have to do this.
			temp = this.card[i];
			this.card[i] = this.card[set];
			this.card[set] = temp;
		}	
	}
	
	// Pick the card from top of deck
	public Card nextCard()
	{
		if (this.card[0] == null)
		{
			return null;
		}
		else
		{
			//get top card
			Card top = this.card[0];
					
			//Move the dealt card so it can be later deleted // -1
			for (int i = 1; i < this.cardNumber; i++) 
			{
				this.card[i-1] = this.card[i]; 
			}
			//To delete the last card to make sure its same position/ Set it to Null
			this.card[this.cardNumber-1] = null;
			//After dealt the count of cards in deck goes down --
			this.cardNumber--;
					
			return top;
		}
	}

	// Refill the deck once it becomes empty
	public void RefillDeck()
	{
		RefillDeck(false);
	}
	public void RefillDeck(boolean shuffle)
	{
		// get new shuffled deck
		Deck newDeck = ((shuffle) ? new Deck(true) : new Deck(false));
		
		for(int x=cardNumber; x < 52; x++)
		{
			this.card[cardNumber] = newDeck.nextCard();
			this.cardNumber++;
		}
	}

	// Get # of card on deck
	public int CardsOnDeck()
	{
		return cardNumber;
	}
}

	

