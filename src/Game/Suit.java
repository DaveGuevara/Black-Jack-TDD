package Game;

/**  
 * Creation of Suits
 * Created: April 20, 2017 
 * Author: Khaled & David
 * 
 */

//4 Suits That are In the Deck
public enum Suit 
{
	//clubs - 0, diamonds - 1, spades - 2, hearts - 3
	Clubs("Clubs"),	Diamonds("Diamonds"), Spades("Spades"),	Hearts("Hearts");
	
	private String Suit;

	private Suit(String suit) {
		Suit = suit;
	}
	
	@Override
	public String toString() {
		
		return Suit;
	}
	
}

