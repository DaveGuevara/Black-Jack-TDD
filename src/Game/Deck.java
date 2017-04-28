package Game;

import java.util.Random;
import java.util.Scanner;

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
		//Random number generator
		Random random = new Random();
		// temporary card
		Card temp;
		int set;
		
		for (int i = 0; i < this.cardNumber; i++){
			
			// get a random random to swap card i with
			set = random.nextInt(this.cardNumber);
			
			// do swap do it like this so we do not lose the value 
			// so "i" have to do this.
			temp = this.card[i];
			this.card[i] = this.card[set];
			this.card[set] = temp;
		}
		
	}
	
	
}

	

