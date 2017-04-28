package Game;

/**  
 * Creation of Suits
 * Created: April 20, 2017 
 * Author: Khaled & David
 * 
 */

//4 Suits That are In the Deck
public enum Suit {

	Clubs("Clubs"),	Diamonds("Diamonds"), Spades("Spades"),	Hearts("Spades");
	
	private String Suit;

	private Suit(String suit) {
		Suit = suit;
	}
	
	@Override
	public String toString() {
		
		return Suit;
	}
	
}

