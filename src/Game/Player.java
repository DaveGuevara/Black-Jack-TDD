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
	private int BuyIn; 	// buy in money (amount required to start each game)
	
	///constructor
	public Player(String name, int buyin) 
	{
		this.Name = name;
		this.BetMoney = buyin;
		this.emptyHand();
		this.BuyIn = buyin;
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
	public boolean adjustBetMoney(int betmoney)
	{
		// bet exceed balance		
		if (betmoney < 0 & Math.abs(betmoney) > this.BetMoney){ return false; }
		
		this.BetMoney += betmoney;  //subtracting money from your balance
		return true;		
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
	// Get Number of cards holding
	public int getBetMoneyBalance()
	{
		return this.BetMoney;
	}
	// Get holding cards
	public Card[] getHoldingCards()
	{
		return this.holdingHand;
	}
	// RESET player to play a new game
	public void Reset()
	{
		this.BetMoney = this.BuyIn;
		this.emptyHand();
	}
	// Print dealer name
	public String ToString()
	{
		return this.Name;
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
