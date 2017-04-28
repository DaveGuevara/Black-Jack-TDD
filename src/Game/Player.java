package Game;


/**  
 * Creation of Player 
 * Created: April 20, 2017 
 * Author: Khaled & David
 * 
 */
public class Player 
{
	//name
	private String Name;
	//current amount of cards the player is holding 
	private int cardNumber;
	//max of 21 cards per player
	private Card[] holdingHand = new Card[21];
	//bet money
	private float BetMoney;
	
	///constructor
	public Player(String name, float betMoney) 
	{
		this.Name = name;
		this.BetMoney = betMoney;
		this.emptyHand();
	}
	
	//HELPER -- Empty hand 
	public void emptyHand() 
	{
		for (int i = 0; i < 21; i++) 
		{  //Set it to Null
			this.holdingHand[i] = null;
		}
		//set the # to 0 of card
		this.cardNumber = 1;
	}
	
	//STORE ASSIGNED CARD
	public boolean addCard(Card card) 
	{
		// Max of 21 cards 
		try
		{
			if (this.holdingHand.length == 21) 
			{
				return false; 
			}
			else
			{
				this.holdingHand[this.cardNumber] = card;
				cardNumber++;
			}
		}
		catch(Exception e)
		{
			
		}
		
		//make sure its 21 or under 
		return (this.getHandSum() <= 21);
	}
	
	// GET SUM OF CURRENT HAND
	public int getHandSum()
	{
		int holdingTotal = 0;
		
		//Sum of the cards in hand or count
		for (int i = 0; i < this.cardNumber; i++) 
		{
			holdingTotal += this.holdingHand[i].GetCardValue();
		}
		
		return holdingTotal;
	}

	
}