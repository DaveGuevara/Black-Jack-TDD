package Game;

/**  
 * Creation of Player 
 * Created: April 20, 2017 
 * Author: Khaled & David
 * 
 */
public class Player 
{
	private String Name; 		// name of current player
	private int cardsHolding;		// number of cards the player is currently holdling
	private Card[] holdingHand = new Card[21];  // array of playing cards (max 21)
	private int BetMoney;		// bet money
	
	///constructor
	public Player(String name, int betMoney) 
	{
		this.Name = name;
		this.BetMoney = betMoney;
		this.emptyHand();
	}
	
	//STORE ASSIGNED CARD
	public boolean addCard(Card card) 
	{
		if(this.getCardCount() < 21)
		{
			this.holdingHand[this.cardsHolding] = card;
			this.cardsHolding++;
			
			return true;
		}
		else
		{
			return false;
		}
	}

	// ADJUST BET MONEY
	public void adjustBetMoney(int betmoney)
	{
		this.BetMoney += (betmoney);
	}
	
	// GET SUM OF CURRENT HAND
	public int getHandSum()
	{
		int holdingTotal = 0;
		
		//Sum of the cards in hand or count
		for (int i = 0; i < this.cardsHolding; i++) { holdingTotal += this.holdingHand[i].GetCardValue();}
		
		return holdingTotal;
	}
	
	// Get Number of cards holding
	public int getCardCount()
	{
		return this.cardsHolding;
	}

	
	//HELPER -- Empty hand 
	public void emptyHand() 
	{
		for (int i = 0; i < 21; i++) 
		{  //Set it to Null
			this.holdingHand[i] = null;
		}
		//set the # to 0 of card
		this.cardsHolding = 0;
	}
}
